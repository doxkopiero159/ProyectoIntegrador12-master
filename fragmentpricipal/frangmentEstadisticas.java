package com.pierogranda.proyectointegrador12.fragmentpricipal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pierogranda.proyectointegrador12.R;
import com.pierogranda.proyectointegrador12.fragment.diagramaBarras;
import com.pierogranda.proyectointegrador12.fragment.diagramaCircular;

public class frangmentEstadisticas extends Fragment {


    public frangmentEstadisticas() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_frangment_estadisticas, container, false);


        Button button =view.findViewById(R.id.btn_barras);
        Button button1=view.findViewById(R.id.btn_circulo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new diagramaBarras();
                getFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();


                Fragment fragment1=new diagramaCircular();
                getFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();

            }
        });





        return  view;
    }




}
