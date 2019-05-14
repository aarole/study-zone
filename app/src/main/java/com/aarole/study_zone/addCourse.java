package com.aarole.study_zone;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class addCourse extends AppCompatActivity {

    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> hours = new ArrayList<>();
    private static int t = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        final EditText course = findViewById(R.id.txtCourse);
        final EditText hour = findViewById(R.id.txtHours);

        findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setT(0);
                finish();
            }
        });

        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(course.getText().toString())){
                    course.setError("Course name cannot be empty!");
                    return;
                }
                if(TextUtils.isEmpty(hour.getText().toString())){
                    hour.setError("Hours studied cannot be empty!");
                    return;
                }
                String course1 = course.getText().toString();
                String hour1 = hour.getText().toString();
                int i = 1;
                t = 1;

                courses.add(course1);
                hours.add(hour1);

                Intent intent = new Intent(addCourse.this, stats.class);
                intent.putExtra("courseArray", course1);
                intent.putExtra("hourArray", hour1);
                intent.putExtra("test", i);
//                test.writeData(i, addCourse.this);
                startActivity(intent);
                finish();
            }
        });
    }

    public static int getT(){
        return t;
    }

    public static void setT(int temp){
        t = temp;
    }
}
