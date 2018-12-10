package com.pierogranda.proyectointegrador12.fragmentpricipal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pierogranda.proyectointegrador12.R;
import com.pierogranda.proyectointegrador12.fragment.FirstFragment;


public class frangmentEstadisticas extends Fragment implements View.OnClickListener {



    public void showFirstFragment(View view){
        // Get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Create FirstFragment
        Fragment fragment = new FirstFragment();
        // Replace content
        fragmentManager.beginTransaction().replace(R.id.content,
                fragment).addToBackStack("tag").commit();
    }

    private FragmentManager getSupportFragmentManager() {

        return null;
    }


    public frangmentEstadisticas() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_frangment_estadisticas,container,false);
        Button b=(Button)v.findViewById(R.id.id_barrar);
        b.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {

    }
}







