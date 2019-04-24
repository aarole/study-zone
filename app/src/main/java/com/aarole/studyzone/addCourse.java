package com.aarole.studyzone;


        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

        import java.util.ArrayList;

public class addCourse extends AppCompatActivity {

    private ArrayList<String> courses = new ArrayList<>();
    private ArrayList<String> hours = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        final EditText course = findViewById(R.id.txtCourse);
        final EditText hour = findViewById(R.id.txtHours);

        findViewById(R.id.cancelBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course1 = course.getText().toString();
                String hour1 = hour.getText().toString();
                int i = 1;

                courses.add(course1);
                hours.add(hour1);

                Intent intent = new Intent(addCourse.this, stats.class);
                intent.putExtra("courseArray", course1);
                intent.putExtra("hourArray", hour1);
                intent.putExtra("test", i);
                startActivity(intent);
                finish();
            }
        });
    }
}
