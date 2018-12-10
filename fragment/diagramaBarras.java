package com.pierogranda.proyectointegrador12.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierogranda.proyectointegrador12.R;

public class diagramaBarras extends Fragment {



    private static final String TAG = diagramaCircular.class.getSimpleName();

    public diagramaBarras() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_diagrama_barras  , container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onCreateView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onCreateView");
    }

}