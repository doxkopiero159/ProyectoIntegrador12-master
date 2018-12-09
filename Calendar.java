package com.pierogranda.proyectointegrador12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class Calendar extends AppCompatActivity {
    private CalendarView calendarView;
    private TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarview);
        dateDisplay = (TextView) findViewById(R.id.date_display);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                dateDisplay.setText("fecha: " + i2 + " / " + (i1+1) + " / " + i);
                Toast.makeText(getApplicationContext(),
                        "fecha:\n" + "dia = " + i2 + "\n" + "Mes = " + (i1+1) + "\n" + "año = " + i,
                        Toast.LENGTH_LONG).show();
            }
        });
    }}
