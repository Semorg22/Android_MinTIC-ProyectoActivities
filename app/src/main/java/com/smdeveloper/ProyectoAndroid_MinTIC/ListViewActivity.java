package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv1;

    private MyDBSQliteHelper admin;
    private SQLiteDatabase db;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv1 = findViewById(R.id.listView);
        ArrayList<String> listado = new ArrayList<String>();

        admin = new MyDBSQliteHelper(this, vars.db,null,vars.version);

        Bundle extras = getIntent().getExtras();
        String nomTabla = extras.getString("nomTabla");
        setTitle(nomTabla);

        db = admin.getReadableDatabase();
        fila = db.rawQuery("SELECT * FROM empleado", null);
        while(fila.moveToNext()){
            listado.add(fila.getString(0) + ".  " + fila.getString(1) + " / " + fila.getString(2) + " / " + fila.getString(3) + "\n");
        }
        db.close();

        /*listado.add("Elemento #1");
        listado.add("Elemento #2");
        for (int i = 3; i < 50; i++) {
            listado.add("Elemento #" + i);
        }*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,listado);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Posición: " + position + "\n" + lv1.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Destruir la activity
    public void onBackPressed() {
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}