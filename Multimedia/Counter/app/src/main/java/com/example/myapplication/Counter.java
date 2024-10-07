package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;

public class Counter extends AppCompatActivity {
    private int uno = 0, dos = 0, tres = 0;
    private Button Masuno1, Masuno2, Masuno3, reset, reset2, reset3, mainReset;
    private TextView Zero1, Zero2, Zero3;

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

        // Initializing views
        Masuno1 = findViewById(R.id.masunouno);
        Masuno2 = findViewById(R.id.masunodos);
        Masuno3 = findViewById(R.id.masunotres);
        mainReset = findViewById(R.id.mainReset);
        reset = findViewById(R.id.reset);
        reset2 = findViewById(R.id.resetdos);
        reset3 = findViewById(R.id.resettres);
        Zero1 = findViewById(R.id.Zero1);
        Zero2 = findViewById(R.id.Zero2);
        Zero3 = findViewById(R.id.Zero3);

        // Setting individual click listeners for each button
        Masuno1.setOnClickListener(v -> {
            uno++;
            Zero1.setText(String.valueOf(uno));
        });

        Masuno2.setOnClickListener(v -> {
            dos++;
            Zero2.setText(String.valueOf(dos));
        });

        Masuno3.setOnClickListener(v -> {
            tres++;
            Zero3.setText(String.valueOf(tres));
        });

        reset.setOnClickListener(v -> {
            uno = 0;
            Zero1.setText(String.valueOf(uno));
        });

        reset2.setOnClickListener(v -> {
            dos = 0;
            Zero2.setText(String.valueOf(dos));
        });

        reset3.setOnClickListener(v -> {
            tres = 0;
            Zero3.setText(String.valueOf(tres));
        });

        mainReset.setOnClickListener(v -> {
            uno = 0;
            dos = 0;
            tres = 0;
            Zero1.setText(String.valueOf(uno));
            Zero2.setText(String.valueOf(dos));
            Zero3.setText(String.valueOf(tres));
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("unouno",uno);
        outState.putInt("dosdos",dos);
        outState.putInt("trestres",tres);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savevalue){
        super.onRestoreInstanceState(savevalue);
        if(savevalue != null){
            Zero1.setText(String.valueOf(savevalue.getInt("unouno")));
            Zero2.setText(String.valueOf(savevalue.getInt("dosdos")));
            Zero3.setText(String.valueOf(savevalue.getInt("trestres")));

        }

    }

}
