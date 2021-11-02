package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show(); //Crear un mini mensaje
        Log.i("Información","onCreate"); //console log normal, para ver cositas en la consola
         */
    }

    public void goToActivitySecond(View view) { //movernos entre activities
        Intent newIntent = new Intent(this,SecondActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //evita crear pestañas continuas
        newIntent.putExtra("msg","Hola MinTIC");
        newIntent.putExtra("year",2021);
        startActivity(newIntent);
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Información","onDestroy");
    }

     */
}