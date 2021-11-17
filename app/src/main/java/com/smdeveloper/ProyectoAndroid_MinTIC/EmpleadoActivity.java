package com.smdeveloper.ProyectoAndroid_MinTIC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EmpleadoActivity extends AppCompatActivity {

    private MyDBSQliteHelper admin;
    private SQLiteDatabase db;
    private ContentValues cv;
    private Cursor fila;

    private EditText et1, et2, et3, et4, et5, et6, et7;
    private Spinner sp1, sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);

        admin = new MyDBSQliteHelper(this,vars.db,null,vars.version);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Soporte de actionBar.mostrar felchita para devolverse
        getParametros();

        et1 = findViewById(R.id.input_dni);
        et2 = findViewById(R.id.input_nombre);
        et3 = findViewById(R.id.input_apellido);
        et4 = findViewById(R.id.input_fecha_nac);
        et5 = findViewById(R.id.input_telef);
        et6 = findViewById(R.id.input_direcc);
        et7 = findViewById(R.id.input_email);

        sp1 = findViewById(R.id.spinner_estado_civil);
        sp2 = findViewById(R.id.spinner_cargo);
    }

    public void agregarDatos (View view) {
        String dni = et1.getText().toString();
        String nom = et2.getText().toString();
        String ape = et3.getText().toString();
        if(!dni.equals("") && !nom.equals("") && !ape.equals("")){
            db = admin.getWritableDatabase();
            cv = new ContentValues();
            cv.put("dni",dni);
            cv.put("nombre", nom);
            cv.put("apellidos", ape);
            long registro = db.insert("empleado",null,cv);
            if(registro == -1){
                Toast.makeText(this, "No se pudo agregar el registro", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Registro almacenado", Toast.LENGTH_SHORT).show();
                et1.setText("");
                et1.requestFocus();
                et2.setText("");
                et3.setText("");
            }
        }
        else{
            Toast.makeText(this, "Por favor, ingrese los datos", Toast.LENGTH_SHORT).show();
        }
    }
    public void listarDatos (View view) {

        /*db = admin.getReadableDatabase();
        fila = db.rawQuery("SELECT * FROM empleado", null);
        String datos = "";
        while(fila.moveToNext()){
            datos += fila.getString(0) + " - " + fila.getString(1) + " " + fila.getString(2) + "\n";
        }
        db.close();*/

        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("nomTabla", "Empleado");
        startActivity(intent);
    }
    public void eliminarDatos (View view) {
        String dni = et1.getText().toString();
        if(!dni.equals("")){
            db = admin.getWritableDatabase();
            //int reg = db.delete("empleado", "dni='"+dni+"'",null);
            String[] args =  new String[]{dni};
            int reg = db.delete("empleado", "dni=?",args);
            if(reg == 0){
                Toast.makeText(this, "No se pudo eliminar el registro", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Por favor ingrese la identificación", Toast.LENGTH_SHORT).show();
        }

    }
    public void buscarDatos (View view) {
        String dni = et1.getText().toString();
        if(!dni.equals("")){
            db = admin.getReadableDatabase();
            fila = db.rawQuery("SELECT * FROM empleado WHERE dni='"+dni+"'", null);
            if(fila.getCount() > 0){
                if(fila.moveToFirst()){
                    et2.setText(fila.getString(2));
                    et3.setText(fila.getString(3));
                }
                db.close();
            }
            else{
                Toast.makeText(this, "El empleado no existe", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Por favor ingrese la identificación", Toast.LENGTH_SHORT).show();
        }
    }
    public void editarDatos (View view) {
        String dni = et1.getText().toString();
        String nom = et2.getText().toString();
        String ape = et3.getText().toString();
        if(!dni.equals("") && !nom.equals("") && !ape.equals("")){
            db = admin.getWritableDatabase();
            cv = new ContentValues();
            cv.put("nombre", nom);
            cv.put("apellidos", ape);
            long reg = db.update("empleado",cv,"dni='"+dni+"'",null);
            if(reg == 0){
                Toast.makeText(this, "No se pudo editar el registro", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Registro editado", Toast.LENGTH_SHORT).show();
                et1.setText("");
                et1.requestFocus();
                et2.setText("");
                et3.setText("");
            }
        }
        else{
            Toast.makeText(this, "Por favor, ingrese los datos", Toast.LENGTH_SHORT).show();
        }

    }
    public void limpiarDatos (View view) {
        et1.setText("");
        et1.requestFocus();
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
        sp1.setSelection(0);
        sp2.setSelection(0);
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

    public void getParametros() {
        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("msg");
        int year = extras.getInt("year");
        Toast.makeText(this, msg + " " + year, Toast.LENGTH_SHORT).show();
    }
}