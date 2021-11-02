package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onKeyDown(int keyCode, KeyEvent event) { //Confirmación de salir de la app, dialogo como optionPane
        if(keyCode == KeyEvent.KEYCODE_BACK){
            new AlertDialog.Builder(this,R.style.Theme_AppCompat_DayNight_Dialog_Alert)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Información")
                    .setMessage("¿Desea salir?")
                    .setNegativeButton("No",null)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                        }
                    }).show();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //poner el menu que creamos en el actionBar
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.mnu_second_activity) {
            Intent newIntent = new Intent(this,SecondActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //evita crear pestañas continuas
            newIntent.putExtra("msg","Hola MinTIC");
            newIntent.putExtra("year",2021);
            startActivity(newIntent);
        }
        else if(id == R.id.mnu_third_activity) {
            Intent newIntent = new Intent(this,ThirdActivity.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //evita crear pestañas continuas
            startActivity(newIntent);
        }
        return super.onOptionsItemSelected(menuItem);
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