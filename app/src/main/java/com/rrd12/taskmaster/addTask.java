package com.rrd12.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTask = addTask.this.findViewById(R.id.addTask);
        addTask.setOnClickListener(v -> {
            TextView submitted = addTask.this.findViewById(R.id.addTaskPopup);
            submitted.setText("Submitted");
        });
    }
}