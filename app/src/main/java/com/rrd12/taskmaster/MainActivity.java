package com.rrd12.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTaskButton = MainActivity.this.findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v -> {
            Intent goToAddTaskIntent = new Intent(MainActivity.this, AddTask.class);
            startActivity(goToAddTaskIntent);
        });

        Button allTaskButton = MainActivity.this.findViewById(R.id.allTasksButton);
        allTaskButton.setOnClickListener(v -> {
            Intent goToAllTaskIntent = new Intent(MainActivity.this, AllTasks.class);
            startActivity(goToAllTaskIntent);
        });

        Button settingsButton = MainActivity.this.findViewById(R.id.settingB);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettings = new Intent(MainActivity.this, Settings.class);
            startActivity(goToSettings);
        });
    }
}