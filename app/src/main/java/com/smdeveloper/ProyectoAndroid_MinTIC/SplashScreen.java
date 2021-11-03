package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Bloquear rotación de pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Ocultar Barra Notificaciones
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Oculutar actionBar
        getSupportActionBar().hide();

        //Tarea de temporización
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent newintent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(newintent);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,SPLASH_SCREEN_DELAY);
    }
}