package com.rrd12.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String TASK_TITLE = "Task Title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        addTaskButton();
        allTaskButton();
        settingsButton();
        taskOneButton();
        taskTwoButton();
        taskThreeButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUsername();
    }

    private void updateUsername(){
        String username = preferences.getString(Settings.USERNAME, "My Tasks");
        String formattedTitle = String.format("%s's Tasks",username);
        TextView usernameTaskTitle = findViewById(R.id.usernameTaskTitle);
        usernameTaskTitle.setText(formattedTitle);
    }

    private void addTaskButton(){
        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(v -> {
            Intent goToAddTaskIntent = new Intent(MainActivity.this, AddTask.class);
            startActivity(goToAddTaskIntent);
        });
    }
    private void allTaskButton(){
        Button allTaskButton = findViewById(R.id.allTasksButton);
        allTaskButton.setOnClickListener(v -> {
            Intent goToAllTaskIntent = new Intent(MainActivity.this, AllTasks.class);
            startActivity(goToAllTaskIntent);
        });
    }
    private void settingsButton(){
        Button settingsButton = findViewById(R.id.settingB);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettings = new Intent(MainActivity.this, Settings.class);
            startActivity(goToSettings);
        });
    }

    private void taskOneButton(){
        Button taskOneB = findViewById(R.id.taskOneB);
        taskOneB.setOnClickListener(v -> {
            Intent goToTaskOne = new Intent(MainActivity.this, TaskDetail.class);
            TextView taskOneTitle = findViewById(R.id.task1);
            String taskOneTitleString = taskOneTitle.getText().toString();
            goToTaskOne.putExtra(TASK_TITLE,taskOneTitleString);
            startActivity(goToTaskOne);
        });
    }
    private void taskTwoButton(){
        Button taskTwoB = findViewById(R.id.taskTwoB);
        taskTwoB.setOnClickListener(v -> {
            Intent goToTaskTwo = new Intent(MainActivity.this, TaskDetail.class);
            TextView taskTwoTitle = findViewById(R.id.task2);
            String taskTwoTitleString = taskTwoTitle.getText().toString();
            goToTaskTwo.putExtra(TASK_TITLE,taskTwoTitleString);
            startActivity(goToTaskTwo);
        });
    }
    private void taskThreeButton(){
        Button taskThreeB = findViewById(R.id.taskThreeB);
        taskThreeB.setOnClickListener(v -> {
            Intent goToTaskThree = new Intent(MainActivity.this, TaskDetail.class);
            TextView taskThreeTitle = findViewById(R.id.task3);
            String taskThreeTitleString = taskThreeTitle.getText().toString();
            goToTaskThree.putExtra(TASK_TITLE,taskThreeTitleString);
            startActivity(goToTaskThree);
        });
    }
}