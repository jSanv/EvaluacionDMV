package com.example.evaluaciondmv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import Adaptador.adaptable;

import static com.example.evaluaciondmv.MainActivity.lstestudiantes;

public class Lista extends AppCompatActivity {

    ListView milista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        milista = findViewById(R.id.lista);
        this.milista.setAdapter(new adaptable(this,
                R.layout.listpersonalizada,lstestudiantes));

    }
}
