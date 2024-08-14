package com.example.practica_activity_listview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListViewDatos extends AppCompatActivity {

    ArrayList<Estudiante> estudianteList;
    ListView listaEstudiantes;
    Button filtro;
    Spinner item;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaEstudiantes=findViewById(R.id.listaEstudiantes);
        item=findViewById(R.id.spFiltro);
        filtro=findViewById(R.id.btnFiltro);

        estudianteList=(ArrayList<Estudiante>) getIntent().getSerializableExtra("Lista");

        if (estudianteList!=null){
            ArrayAdapter<Estudiante> adapter=new ArrayAdapter<>(this,R.layout.listviewpersonalizado,estudianteList);
            listaEstudiantes.setAdapter(adapter);
        }


    }

    public void Filtrar(View v){
        String itemParaFiltrar = item.getSelectedItem().toString();

        ArrayList<Estudiante> listaFiltrada = (ArrayList<Estudiante>) estudianteList.stream()
                .filter(estudiante -> estudiante.getCarrera().equals(itemParaFiltrar))
                .collect(Collectors.toList());

        ArrayAdapter<Estudiante> adapter = new ArrayAdapter<>(this, R.layout.listviewpersonalizado, listaFiltrada);
        listaEstudiantes.setAdapter(adapter);
        }
    }

