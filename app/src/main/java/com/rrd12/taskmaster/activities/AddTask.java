package com.rrd12.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.rrd12.taskmaster.R;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Button addTask = AddTask.this.findViewById(R.id.addTask);
        addTask.setOnClickListener(v -> {
            TextView submitted = AddTask.this.findViewById(R.id.addTaskPopup);
            submitted.setText("Submitted");
        });
    }
}