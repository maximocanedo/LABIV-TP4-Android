package com.max.utnfrgp.labiv.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;

public class TercerEjercicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercer_ejercicio);
        RadioGroup rgr = (RadioGroup)findViewById(R.id.radioGroupOS);
        CheckBox cbProg = (CheckBox) findViewById(R.id.cbProgramacion);
        CheckBox cbAdmn = (CheckBox) findViewById(R.id.cbAdministracion);
        CheckBox cbDsGf = (CheckBox) findViewById(R.id.cbDGrafico);
        EditText txtHoras = (EditText) findViewById(R.id.txtCantHorasPC);
        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedOS = rgr.getCheckedRadioButtonId();
                int sos = 0;
                switch(selectedOS) {
                    case R.id.radioWindows:
                        sos = 0;
                        break;
                    case R.id.radioMac:
                        sos = 1;
                        break;
                    case R.id.radioLinux:
                        sos = 2;
                        break;
                    default:
                        sos = 0;
                        break;
                }

                String[] os = {"Windows", "Mac", "Linux"};
                String slos = os[sos];

                String total = slos;

                if(cbProg.isChecked()) total += " - Programación";
                if(cbAdmn.isChecked()) total += " - Administración";
                if(cbDsGf.isChecked()) total += " - Diseño Gráfico";

                total += " " + txtHoras.getText().toString() + "hs.";

                Snackbar sn = Snackbar.make(findViewById(R.id.cPr), total, Snackbar.LENGTH_LONG);
                sn.show();
            }
        });



    }
}