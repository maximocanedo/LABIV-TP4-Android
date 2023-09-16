package com.max.utnfrgp.labiv.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrimerEjercicio = (Button)findViewById(R.id.btnPrimerEjercicio);
        Button btnSegundoEjercicio = (Button)findViewById(R.id.btnSegundoEjercicio);
        btnPrimerEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PrimerEjercicio.class));
            }
        });
        btnSegundoEjercicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SegundoEjercicio.class));
            }
        });


    }
}