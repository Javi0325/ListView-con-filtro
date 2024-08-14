package com.example.practica_activity_listview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Estudiante> estudiantes;
    EditText nombre, apellido, edad;
    RadioButton hombre, mujer, otro;
    Spinner carreras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar la lista de estudiantes
        estudiantes = new ArrayList<>();

        nombre = findViewById(R.id.ptNombre);
        apellido = findViewById(R.id.ptApellido);
        edad = findViewById(R.id.ptEdad);
        hombre = findViewById(R.id.rbMasculino);
        mujer = findViewById(R.id.rbFemenino);
        otro = findViewById(R.id.rbOtro);
        carreras = findViewById(R.id.spCarrera);
    }

    public void añadirDatos(View v) {
        String EstNombre = nombre.getText().toString();
        String EstApellido = apellido.getText().toString();
        String EstEdad = edad.getText().toString();
        String EstSexo = "";
        String EstCarrera = carreras.getSelectedItem().toString();

        if (hombre.isChecked()) {
            EstSexo = hombre.getText().toString();
        } else if (mujer.isChecked()) {
            EstSexo = mujer.getText().toString();
        } else {
            EstSexo = otro.getText().toString();
        }

        Estudiante est = new Estudiante(EstNombre, EstApellido, EstEdad, EstSexo, EstCarrera);
        estudiantes.add(est);
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        carreras.setSelection(0);
        hombre.setChecked(false);
        mujer.setChecked(false);
        otro.setChecked(false);
        Toast.makeText(getApplicationContext(), "Se registro exitosamente", Toast.LENGTH_SHORT).show();
    }

    public void enviarDatos(View v) {
        Intent ds = new Intent(getApplicationContext(), ListViewDatos.class);
        ds.putExtra("Lista", (Serializable) estudiantes);
        startActivity(ds);
    }
}