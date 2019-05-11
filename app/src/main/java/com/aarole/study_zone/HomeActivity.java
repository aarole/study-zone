package com.aarole.study_zone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.reminderBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, pickActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.musicBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(HomeActivity.this, playlistPicker.class);
                startActivity(intent2);
            }
        });
        findViewById(R.id.listBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(HomeActivity.this, todo.class);
                startActivity(intent3);
            }
        });
        findViewById(R.id.statsBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choice = courseIO.readData(HomeActivity.this).size();

                if(choice == 0){
                    startActivity(new Intent(HomeActivity.this, addCourse.class));
                }
                else{
                    addCourse.setT(0);
                    startActivity(new Intent(HomeActivity.this, stats.class));
                }
            }
        });
    }
}
