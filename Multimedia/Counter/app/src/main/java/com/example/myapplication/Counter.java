package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Counter extends AppCompatActivity {

    private Button Masuno1,Masuno2,Masuno3,reset,reset2,reset3;
    private TextView Zero1,Zero2,Zero3;
    public int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Masuno1=findViewById(R.id.masunouno);
        Masuno2=findViewById(R.id.masunodos);
        Masuno3=findViewById(R.id.masunotres);
        reset=findViewById(R.id.reset);
        reset2=findViewById(R.id.resetdos);
        reset3=findViewById(R.id.resettres);
        Zero1=findViewById(R.id.Zero1);
        Zero2=findViewById(R.id.Zero2);
        Zero3=findViewById(R.id.Zero3);


    }




}