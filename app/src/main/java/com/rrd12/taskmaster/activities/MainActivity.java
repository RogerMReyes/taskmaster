package com.rrd12.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

import com.rrd12.taskmaster.R;
import com.rrd12.taskmaster.adapter.TaskListRecViewAdapter;
import com.rrd12.taskmaster.models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String TASK_TITLE = "Task Title";
    public static final String TASK_BODY = "Task Body";
    public static final String TASK_STATE = "Task State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        simpleButtonActivity(R.id.addTaskButton, AddTask.class);
        simpleButtonActivity(R.id.allTasksButton, AllTasks.class);
        simpleButtonActivity(R.id.settingB, Settings.class);
        taskListRecView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUsername();
    }

    private <T> void simpleButtonActivity(int id, Class<T> c){
        buttonGo(findViewById(id), new Intent(MainActivity.this, c));
    }
    private void buttonGo(Button button, Intent goWhere){
        button.setOnClickListener(v->{
            startActivity(goWhere);
        });
    }

    private void updateUsername(){
        String username = preferences.getString(Settings.USERNAME, "My Tasks");
        String formattedTitle = String.format("%s's Tasks",username);
        TextView usernameTaskTitle = findViewById(R.id.usernameTaskTitle);
        usernameTaskTitle.setText(formattedTitle);
    }

    private void taskListRecView(){
        RecyclerView taskList = findViewById(R.id.taskList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskList.setLayoutManager(layoutManager);

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task("Task One"));
        tasks.add(new Task("Task Two"));
        tasks.add(new Task("Task Three"));
        tasks.add(new Task("Task Four"));
        tasks.add(new Task("Task Five"));
        tasks.add(new Task("Task Six"));
        tasks.add(new Task("Task Seven"));

        TaskListRecViewAdapter adapter = new TaskListRecViewAdapter(tasks, this);
        taskList.setAdapter(adapter);
    }
}