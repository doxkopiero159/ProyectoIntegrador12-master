package com.pierogranda.proyectointegrador12.fragmentpricipal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pierogranda.proyectointegrador12.Estadisticas;
import com.pierogranda.proyectointegrador12.R;
import com.pierogranda.proyectointegrador12.fragment.FirstFragment;


public class frangmentEstadisticas extends Fragment  {






    public frangmentEstadisticas() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_frangment_estadisticas,container,false);

        return v;


    }



}







