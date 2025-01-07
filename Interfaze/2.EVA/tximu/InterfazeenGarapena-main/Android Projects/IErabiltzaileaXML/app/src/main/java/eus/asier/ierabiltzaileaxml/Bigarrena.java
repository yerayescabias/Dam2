package eus.asier.ierabiltzaileaxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Bigarrena extends AppCompatActivity {
    private CheckBox checkBox;
    private Button btnBai, btnEz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bigarrena);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        btnBai = (Button)findViewById(R.id.btnBai);
        btnEz = (Button)findViewById(R.id.btnEz);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (checkBox.isChecked())
                {
                    btnBai.setText(R.string.bai_en);
                    btnEz.setText(R.string.ez_en);
                }
                else
                {
                    btnBai.setText(R.string.bai_eu);
                    btnEz.setText(R.string.ez_eu);
                }
            }
        });
    }
}