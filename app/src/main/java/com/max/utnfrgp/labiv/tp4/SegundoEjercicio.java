package com.max.utnfrgp.labiv.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class SegundoEjercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_ejercicio);

        // Controles
        EditText txtNota1 = (EditText)findViewById(R.id.txtNota1);
        EditText txtNota2 = (EditText)findViewById(R.id.txtNota2);
        EditText txtNota3 = (EditText)findViewById(R.id.txtNota3);
        Spinner spinnerTP = (Spinner)findViewById(R.id.spinnerTP);
        Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
        Button btnNuevo = (Button)findViewById(R.id.btnNuevo);
        Button btnSalir = (Button)findViewById(R.id.btnSalir);
        TextView txtPromedio = (TextView)findViewById(R.id.txtPromedio);
        TextView txtEstado = (TextView)findViewById(R.id.txtEstado);


        String[] items = { "Aprobado", "Desaprobado" };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTP.setAdapter(adapter);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtNota1.getText().toString().trim().length() < 1 || txtNota2.getText().toString().trim().length() < 1 || txtNota3.getText().toString().trim().length() < 1) {
                    Snackbar sn = Snackbar.make(findViewById(R.id.clSegundoEjercicio), "Los campos no pueden estar vacíos. ", Snackbar.LENGTH_SHORT);
                    sn.show();
                    return;
                }


                double nota1 = Double.parseDouble(txtNota1.getText().toString());
                double nota2 = Double.parseDouble(txtNota2.getText().toString());
                double nota3 = Double.parseDouble(txtNota3.getText().toString());
                int tp = spinnerTP.getSelectedItemPosition();

                double promedio = (nota1 + nota2 + nota3) / 3;

                boolean promociona = tp == 0 && promedio >= 8;
                boolean regular = tp == 0 && promedio >= 6 && promedio < 8;
                boolean libre = tp == 1 || promedio < 6;

                String estado = promociona ? "PROMOCIONADO" : (regular ? "REGULAR" : (libre ? "LIBRE" : "CASO ESPECIAL"));
                txtEstado.setText("Estado: " + estado);
                DecimalFormat df = new DecimalFormat("#.##");
                txtPromedio.setText(df.format(promedio));

            }
        });

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtNota1.setText("");
                txtNota2.setText("");
                txtNota3.setText("");
                spinnerTP.setSelection(0);

            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}