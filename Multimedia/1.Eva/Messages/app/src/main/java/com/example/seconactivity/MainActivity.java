package com.example.seconactivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.seconactivity.databinding.ActivityMainBinding;
//import com.example.seconactivity.databinding.SecondViewBinding;



public class MainActivity extends AppCompatActivity {

    // Declarar la variable de View Binding
    private ActivityMainBinding binding ;

    //private SecondViewBinding secondBindig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Habilitar Edge to Edge
        EdgeToEdge.enable(this);
        // Inicializar el View Binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // En lugar de setContentView(R.layout.activity_main), usa el root del binding
        setContentView(binding.getRoot());
        // Aplicar listener de WindowInsets usando el binding
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
        btnSend();
    }

    private void btnSend(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("message",binding.messagesend.getText());
        startActivity(intent);
        getMessage();

    }

    private void getMessage(){
        Intent intentGet= getIntent();
        //secondBindig.messageget.setText(intentGet.getStringExtra("message"));

    }

}
