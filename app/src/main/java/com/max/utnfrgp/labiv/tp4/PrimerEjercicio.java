package com.max.utnfrgp.labiv.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class PrimerEjercicio extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_ejercicio);

        // Elementos
        EditText txtNombre = (EditText) findViewById(R.id.txtNombre);
        EditText txtApellido = (EditText) findViewById(R.id.txtApellido);
        EditText txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        EditText txtFechaNacimiento = (EditText) findViewById(R.id.txtFechaNacimiento);
        Button btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Verificar que esté todo correctamente completado.
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String fechaNacimiento = txtFechaNacimiento.getText().toString();
                String fin = "No llegó al if.";
                boolean todoCompleto = nombre.trim().length() > 0 && apellido.trim().length() > 0 && telefono.trim().length() > 0 && fechaNacimiento.trim().length() > 0;
                if(todoCompleto) {
                    fin = "Los datos ingresados son: "+nombre+" "+apellido+". \nTeléfono: "+telefono+". Fecha de nacimiento: "+fechaNacimiento;
                } else {
                    fin = "Debe completar todos los campos. ";
                }
                int act = R.layout.activity_primer_ejercicio;
                Snackbar sn = Snackbar.make(findViewById(R.id.primerEjercicioActivity), fin, Snackbar.LENGTH_LONG);
                sn.setAction("Limpiar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtTelefono.setText("");
                        txtFechaNacimiento.setText("");
                    }
                });
                sn.show();
            }
        });
    }

}