package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class EncuestaActivity extends AppCompatActivity {

    private TextInputEditText ti1, ti2, ti3, ti4;
    private Spinner sp1;
    private Switch sw1;
    private CheckBox ch1, ch2, ch3, ch4, ch5, ch6;
    private RadioButton rb1, rb2, rb3;
    private TextView tv1;
    private SeekBar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        ti1 = findViewById(R.id.txt_nombre);
        ti2 = findViewById(R.id.txt_fecha_nacimiento);
        ti3 = findViewById(R.id.txt_telefono);
        ti4 = findViewById(R.id.txt_email);

        sp1 = findViewById(R.id.spinner);

        sw1 = findViewById(R.id.switch1);

        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        ch3 = findViewById(R.id.checkBox3);
        ch4 = findViewById(R.id.checkBox4);
        ch5 = findViewById(R.id.checkBox5);
        ch6 = findViewById(R.id.checkBox6);

        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);

        tv1 = findViewById(R.id.textView12);
        sb1 = findViewById(R.id.seekBar2);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    public void VerDatos (View view) {

        String nom = "Nombre: " + ti1.getText().toString();
        String fc_nac = "Fecha de nacimiento: " + ti2.getText().toString();
        String telef = "Telefono: " + ti3.getText().toString();
        String email = "Correo Electrónico: " + ti4.getText().toString();

        String nivel_ingles = "Nivel de Ingles: " + sp1.getSelectedItem();

        String prog = "¿Te gusta programar?: ";
        if(sw1.isChecked()){
            prog += "SI";
        }
        else{
            prog += "NO";
        }

        String leng = "Lenguajes de programación: ";
        if(ch1.isChecked()){
            leng += ch1.getText().toString() + ",";
        }
        if(ch2.isChecked()){
            leng += ch2.getText().toString() + ",";
        }
        if(ch3.isChecked()){
            leng += ch3.getText().toString() + ",";
        }
        if(ch4.isChecked()){
            leng += ch4.getText().toString() + ",";
        }
        if(ch5.isChecked()){
            leng += ch5.getText().toString() + ",";
        }
        if(ch6.isChecked()){
            leng += ch6.getText().toString();
        }
        if(leng.endsWith(",")){
            leng = leng.substring(0,leng.length()-1);
        }

        String experiencia = "Experiencia: ";
        if(rb1.isChecked()){
            experiencia += rb1.getText().toString();
        }
        else if(rb2.isChecked()){
            experiencia += rb2.getText().toString();
        }
        else if(rb3.isChecked()){
            experiencia += rb3.getText().toString();
        }

        String nivel_satisf = "Nivel de Satisfacción (1-10): " + tv1.getText().toString();

        new AlertDialog.Builder(this,R.style.Theme_AppCompat_Dialog_Alert)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle("Datos")
                .setMessage(nom + "\n" + fc_nac + "\n" + telef + "\n" + email
                        + "\n" + nivel_ingles
                        + "\n" + prog
                        + "\n" + leng
                        + "\n" + experiencia
                        + "\n" + nivel_satisf)
                .setPositiveButton("Aceptar", null).show();

    }
}