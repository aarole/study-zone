package com.aarole.study_zone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class playlistPicker extends AppCompatActivity implements randomPicker<Uri>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist_picker);

        Button user = findViewById(R.id.myplaylistsBtn);
        final Button random = findViewById(R.id.randomBtn);
        Button home = findViewById(R.id.homeBtn);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri u = Uri.parse("https://open.spotify.com/collection/playlists");
                Intent intent = new Intent(Intent.ACTION_VIEW, u);
                startActivity(intent);
            }
        });

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri r1 = Uri.parse("https://open.spotify.com/playlist/2jArGkAqIWi2Sx8Hypa31p");
                Uri r2 = Uri.parse("https://open.spotify.com/playlist/7L5cshmVSw9v0X0mZIn78U");
                Uri r3 = Uri.parse("https://open.spotify.com/playlist/37nHJKXeTOgQhwZXvRtGfm");
                Uri r4 = Uri.parse("https://open.spotify.com/playlist/2amhJhphcPln6Ybsjh6IYH");

                Uri[] r = {r1, r2, r3, r4};
                Intent intent1 = new Intent(Intent.ACTION_VIEW, random(r));
                startActivity(intent1);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(playlistPicker.this, HomeActivity.class);
                startActivity(intent2);
            }
        });

        findViewById(R.id.reminderBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(playlistPicker.this, pickActivity.class);
                startActivity(intent3);
            }
        });
        findViewById(R.id.listBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(playlistPicker.this, todo.class);
                startActivity(intent4);
            }
        });
        findViewById(R.id.statsBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choice = courseIO.readData(playlistPicker.this).size();

                if(choice == 0){
                    startActivity(new Intent(playlistPicker.this, addCourse.class));
                }
                else{
                    addCourse.setT(0);
                    startActivity(new Intent(playlistPicker.this, stats.class));
                }
            }
        });
    }

    @Override
    public Uri random(Uri[] a){
        int r = (int)(Math.random()*randomPicker.total);
        return a[r];
    }
}
