package com.pierogranda.proyectointegrador12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PasantiasActivity extends AppCompatActivity {

TextView empresa ,proyecto,duracion,asesor,calificacion,acciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasantias);
        empresa=(TextView)findViewById(R.id.txtEmpresa);
       proyecto=(TextView)findViewById(R.id.txtproyecto);
        duracion=(TextView)findViewById(R.id.txtduracion);
        asesor=(TextView)findViewById(R.id.txtasesor);
        calificacion=(TextView)findViewById(R.id.txtcalifiacion);




    }
}
