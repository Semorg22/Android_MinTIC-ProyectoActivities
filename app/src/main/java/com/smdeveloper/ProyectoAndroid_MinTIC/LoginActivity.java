package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView tv1, tv2;
    private EditText user1, passw1;
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Oculutar actionBar
        getSupportActionBar().hide();

        tv1 = (TextView) findViewById(R.id.textView3);
        user1 = (EditText) findViewById(R.id.editTextTextPersonName);
        passw1 = (EditText) findViewById(R.id.editTextTextPassword);
        //String link = "<a href='https://imaster.academy/course/view.php?id=999&section=3'>IMaster</a>";
        String texto = "<a href=''>Recordar Contraseña</a>";
        tv1.setTextColor(Color.BLUE);
        tv1.setLinkTextColor(Color.BLUE);
        tv1.setText(Html.fromHtml(texto));
        //tv1.setMovementMethod(LinkMovementMethod.getInstance());

        settings = getSharedPreferences("id", Context.MODE_PRIVATE);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user1.getText().toString();
                if (usuario.equals(settings.getString("user", ""))){
                    Toast.makeText(LoginActivity.this, "Su contraseña es: " + settings.getString("pass", ""), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "El usuario no esta registrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv2 = findViewById(R.id.textView13);
        String texto2 = "<a href=''>Registrese</a>";
        tv2.setTextColor(Color.BLUE);
        tv2.setLinkTextColor(Color.BLUE);
        tv2.setText(Html.fromHtml(texto2));
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user1.getText().toString();
                String clave = passw1.getText().toString();
                if(!usuario.equals("") && !clave.equals("")){
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString("user",usuario);
                    editor.putString("pass", clave);
                    editor.commit();
                    user1.setText("");
                    passw1.setText("");
                    Toast.makeText(getApplicationContext(), "Registrado con exito", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Por favor, ingrese el usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void IniciarSesion(View view) {
        String usuario = user1.getText().toString();
        String clave = passw1.getText().toString();
        if(usuario.equals(settings.getString("user","")) && clave.equals(settings.getString("pass",""))) {
            Intent newIntent = new Intent(this, MainActivity.class);
            startActivity(newIntent);
            finish();
        }
        else{
            Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
        if(user1.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese el Usuario", Toast.LENGTH_SHORT).show();
            user1.requestFocus();
        }
        else if(passw1.getText().toString().equals("")) {
            Toast.makeText(this, "Por favor ingrese la contraseña", Toast.LENGTH_SHORT).show();
            passw1.requestFocus();
        }
    }
}