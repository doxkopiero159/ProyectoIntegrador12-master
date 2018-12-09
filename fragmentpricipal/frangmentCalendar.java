package com.pierogranda.proyectointegrador12.fragmentpricipal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.pierogranda.proyectointegrador12.R;




public class frangmentCalendar extends Fragment {


    private CalendarView calendarView;
    private TextView dateDisplay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment






        return inflater.inflate(R.layout.fragment_frangment_calendar, container, false);
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}


