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
import android.widget.Toast;

import com.pierogranda.proyectointegrador12.R;




public class frangmentCalendar extends Fragment {


    private CalendarView calendarView;
    private TextView dateDisplay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frangment_calendar, container, false);


        calendarView = (CalendarView) view.findViewById(R.id.calendarview);
        dateDisplay = (TextView) view.findViewById(R.id.date_display);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                dateDisplay.setText("fecha: " + i2 + " / " + (i1+1) + " / " + i);
                Toast.makeText(getContext(),
                        "fecha:\n" + "dia = " + i2 + "\n" + "Mes = " + (i1+1) + "\n" + "año = " + i,
                        Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


}


