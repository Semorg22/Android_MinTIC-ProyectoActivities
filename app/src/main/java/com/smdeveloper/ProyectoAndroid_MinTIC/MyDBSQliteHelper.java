package com.smdeveloper.ProyectoAndroid_MinTIC;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBSQliteHelper extends SQLiteOpenHelper {

    public MyDBSQliteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory c, int version) {
        super(context, nombre, c, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE empleado(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS empleado");
        db.execSQL("CREATE TABLE empleado(_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT)");
    }

}
