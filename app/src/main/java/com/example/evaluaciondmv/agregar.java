package com.example.evaluaciondmv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import Estudiante.estudiante;

import static com.example.evaluaciondmv.MainActivity.lstestudiantes;

public class agregar extends AppCompatActivity implements View.OnClickListener {

    EditText nombre,codigo,materia,p1,p2,p3;
    Button guardar;
    String n,c,m,par1,par2,par3;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Bundle ag = getIntent().getExtras();

        this.nombre = findViewById(R.id.txtnombre);
        this.codigo = findViewById(R.id.txtcodigo);
        this.materia = findViewById(R.id.txtmateria);
        this.p1 = findViewById(R.id.txtprimerparcial);
        this.p2 = findViewById(R.id.txtsegundoparcial);
        this.p3 = findViewById(R.id.txttercerparcial);
        this.guardar = findViewById(R.id.btnguardar);

        c = nombre.getText().toString();
        n = codigo.getText().toString();
        m = materia.getText().toString();
        par1 = p1.getText().toString();
        par2 = p2.getText().toString();
        par3 = p3.getText().toString();
        contador = ag.getInt("contador");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnguardar:
            {


                String cod = codigo.getText().toString();
                String no = nombre.getText().toString();
                String mater = materia.getText().toString();
                Double parcial1 = Double.parseDouble( p1.getText().toString());
                Double parcial2 = Double.parseDouble(p2.getText().toString()) ;
                Double parcial3 = Double.parseDouble(p3.getText().toString()) ;

                estudiante e = new estudiante();
                e.setCodigo(cod);
                e.setMateria(mater);
                e.setNombre(no);
                e.setParcial1(parcial1);
                e.setParcial2(parcial2);
                e.setParcial3(parcial3);
                e.setPromedio( (parcial1+parcial2+parcial3)/3 );
                lstestudiantes.add(e);

                Intent principal = new Intent(this,MainActivity.class);
                contador++;
                principal.putExtra("contador",contador);
                Toast.makeText(this,"Agregado con exito!, Promedio: "+parcial1,Toast.LENGTH_SHORT).show();
                finish();

                break;
            }
        }
    }
}
