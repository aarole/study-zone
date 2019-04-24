package com.aarole.studyzone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class remList extends AppCompatActivity {

    private ArrayList<String> reminders;
//    private static ArrayList<String> beginTime;
//    private static ArrayList<String> endTime;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rem_list);

        ListView listView = findViewById(R.id.list);
        reminders = remIO.readData(getApplicationContext());
//        beginTime = begIO.readData(getApplicationContext());
//        endTime = endIO.readData(getApplicationContext());


        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,reminders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                Uri uri = Uri.parse("content://calendar/events");
//                intent.setType("vnd.android.cursor.item/event");
//                intent.setData(uri);
//                startActivity(intent);

                String title = reminders.get(position);
//                String begin = beginTime.get(position);
//                String end = endTime.get(position);
                reminders.remove(position);
//                beginTime.remove(position);
//                endTime.remove(position);
                adapter.notifyDataSetChanged();
                remIO.writeData(reminders, remList.this);
//                begIO.writeData(beginTime, remList.this);
//                endIO.writeData(endTime, remList.this);

                Toast.makeText(remList.this, "Make sure to delete the reminder from your Google Calendar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("vnd.android.cursor.item/event");
//                intent.putExtra("beginTime", begin);
//                intent.putExtra("allDay", false);
//                intent.putExtra("title", title);
//                intent.putExtra("endTime", end);
                startActivity(intent);
                finish();

//                long eventId;
//                Uri newuri = ContentUris.withAppendedId(uri, eventId);
//                Intent intent = new Intent(Intent.ACTION_VIEW,newuri);
//                Cursor cursor = getContentResolver().query(newuri, new String[]{"dtstart","dtend",},null, null, null);
//                if(cursor.getCount()>0)
//                {   cursor.moveToFirst();
//                    intent.putExtra("beginTime", cursor.getLong(cursor.getColumnIndex("dtstart")));
//                    intent.putExtra("endTime",  cursor.getLong(cursor.getColumnIndex("dtend")));
//                }

            }
        });
    }
}
