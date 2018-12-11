package com.pierogranda.proyectointegrador12;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class EstadisticaActivity extends AppCompatActivity {

    private PieChart pieChart;
    private BarChart barChart;
    private String[] moths = new String[]{"nota", "puntualidad", "desempeño", "trabajo", "empleador"};
    private int[] sale = new int[]{0, 0, 0, 0, 0};
    private int[] colors = new int[]{Color.BLUE, Color.YELLOW, Color.RED};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        barChart = (BarChart) findViewById(R.id.barchar);
        pieChart = (PieChart) findViewById(R.id.piechar);
        createCharts();

    }

    private Chart getSameChart(Chart chart, String descript, int textColor, int background, int animateY) {
        chart.getDescription().setText(descript);
        chart.getDescription().setTextSize(10);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);

        return chart;
    }

    private void legend(Chart chart) {

        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < moths.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = moths[i];
            entries.add(entry);

        }
        legend.setCustom(entries);

    }


    private ArrayList<BarEntry> getBarEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++)
            entries.add(new BarEntry(i, sale[i]));
        return entries;
    }

    private ArrayList<PieEntry> getPieEntries() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++)
            entries.add(new PieEntry(sale[i]));
        return entries;

    }

    private void axisX(XAxis axis) {
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTTOM);
        axis.setValueFormatter(new IndexAxisValueFormatter(moths));
    }

    private void axisLeft(YAxis axis) {
        axis.setSpaceMax(30);
        axis.setAxisMinimum(0);

    }

    private void axisRight(YAxis axis) {
        axis.setEnabled(false);

    }

    public void createCharts() {
        barChart = (BarChart) getSameChart(barChart, "", Color.YELLOW, Color.WHITE, 3000);
        barChart.setDrawGridBackground(true);
        barChart.setDrawBarShadow(true);
        barChart.setData(getBarData());
        barChart.invalidate();

        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());


        pieChart = (PieChart) getSameChart(pieChart, "", Color.BLUE, Color.WHITE, 3000);
        pieChart.setHoleRadius(10);
        pieChart.setTransparentCircleRadius(22);
        pieChart.setData(getPieData());
        pieChart.invalidate();

    }

    private DataSet getData(DataSet dataSet) {
        dataSet.setColors(colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;


    }

    private BarData getBarData() {
        BarDataSet barDataSet = (BarDataSet) getData(new BarDataSet(getBarEntries(), ""));


        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;

    }

    private PieData getPieData() {
        PieDataSet pieDataSet = (PieDataSet) getData(new PieDataSet(getPieEntries(), ""));
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueFormatter(new PercentFormatter());

        return new PieData(pieDataSet);

    }








}
