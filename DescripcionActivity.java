package com.pierogranda.proyectointegrador12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescripcionActivity extends AppCompatActivity {

TextView nombre,correo,numero,dni,carrea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);


        nombre =(TextView)findViewById(R.id.txtNombre);
        correo =(TextView)findViewById(R.id.txtcorreo);
        numero =(TextView)findViewById(R.id.txtnumero);
        dni =(TextView)findViewById(R.id.txtdni);
        carrea =(TextView)findViewById(R.id.txtcarrera);


    }
}
