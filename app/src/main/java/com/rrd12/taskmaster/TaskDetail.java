package com.rrd12.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        setTaskTitle();
    }

    private void setTaskTitle(){
        Intent callingIntent = getIntent();
        String taskTitle = "";
        if(callingIntent != null){
            taskTitle = callingIntent.getStringExtra(MainActivity.TASK_TITLE);
        }

        TextView taskDetailTitle = findViewById(R.id.taskDetailTitle);
        if(taskTitle != null){
            taskDetailTitle.setText(taskTitle);
        }
        else{
            taskDetailTitle.setText(R.string.no_title);
        }
    }
}