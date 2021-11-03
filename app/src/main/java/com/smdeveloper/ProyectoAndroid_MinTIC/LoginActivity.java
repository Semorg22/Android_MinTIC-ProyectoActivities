package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView tv1;
    EditText user, passw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Oculutar actionBar
        getSupportActionBar().hide();

        tv1 = (TextView) findViewById(R.id.textView3);

        user = (EditText) findViewById(R.id.editTextTextPersonName);
        passw = (EditText) findViewById(R.id.editTextTextPassword);
        //String link = "<a href='https://imaster.academy/course/view.php?id=999&section=3'>IMaster</a>";
        String texto = "<a href=''>Recordar Contraseña</a>";
        tv1.setTextColor(Color.BLUE);
        tv1.setLinkTextColor(Color.BLUE);
            //tv1.setMovementMethod(LinkMovementMethod.getInstance());
        tv1.setText(Html.fromHtml(texto));
        
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Su contraseña es: admin1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void IniciarSesion(View view) {
        if(user.getText().toString().equals("admin1") && passw.getText().toString().equals("admin1")) {
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        }
        else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
        if(user.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese el Usuario", Toast.LENGTH_SHORT).show();
            user.requestFocus();
        }
        else if(passw.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese la contraseña", Toast.LENGTH_SHORT).show();
            passw.requestFocus();
        }
    }
}