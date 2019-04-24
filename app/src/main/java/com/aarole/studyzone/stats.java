package com.aarole.studyzone;
import android.content.Intent;

import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

public class stats extends AppCompatActivity {

    PieChart pieChart ;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;
    ArrayList<String> courses = new ArrayList<>();
    ArrayList<String> hours = new ArrayList<>();
    String course="";
    String hour="0";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        String course1=(String) b.get("courseArray");
        String hour1 =(String) b.get("hourArray");
        i=(int) b.get("test");
        courses.add(course1);
        hours.add(hour1);


        pieChart = (PieChart) findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(1000);

        findViewById(R.id.addbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(stats.this, addCourse.class);
                startActivity(intent1);
            }
        });
        findViewById(R.id.homeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(stats.this, HomeActivity.class);
                startActivity(intent2);
            }
        });

    }

    public void AddValuesToPIEENTRY(){

        for(int i=0;i<hours.size();i++){

            entries.add(new BarEntry(Integer.parseInt(hours.get(i)), i));
        }

    }

    public void AddValuesToPieEntryLabels(){

        for(String e:courses){
            PieEntryLabels.add(e);
        }


    }
}