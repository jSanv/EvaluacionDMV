package com.example.evaluaciondmv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Estudiante.estudiante;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btndatos;
    public static List<estudiante> lstestudiantes;
    public static List<String> listaauxiliar = new ArrayList<String>();
    static int conta =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndatos = (Button) findViewById(R.id.btndatos);

        btndatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,misdatos.class));
            }
        });
        lstestudiantes = new ArrayList<>();

        Bundle ag = getIntent().getExtras();
        if(ag==null) {

        }
        else
        {
            conta = ag.getInt("contador");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnnuevo: {
                Intent as = new Intent(this,agregar.class);
                as.putExtra("contador",conta);
                startActivity(as);
                break;
            }
            case R.id.btnlista:
            {
                if(lstestudiantes.size() ==0 || lstestudiantes == null ) {
                    Toast.makeText(this,"No hay estudiantes registrados!!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent hy = new Intent(this,Lista.class);
                    startActivity(hy);
                }

                break;
            }

        }
    }
}
