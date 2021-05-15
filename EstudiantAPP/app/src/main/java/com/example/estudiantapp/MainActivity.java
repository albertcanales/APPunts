package com.example.estudiantapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;

import com.example.estudiantapp.db.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiantapp.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TXT", "myPrint");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Log.d("TXT", "myPrint");
        Task task1 = new Task("Entregable 4", "CD", new Date(2021, 12, 3));
        Task task2 = new Task("Entregable 5", "CD", new Date(2021, 12, 3));
        Task task3 = new Task("Entregable 6", "CD", new Date(2021, 12, 3));
        Task task4 = new Task("Entregable 7", "CD", new Date(2021, 12, 3));
        Task task5 = new Task("Entregable 8", "CD", new Date(2021, 12, 3));
        Log.d("TXT", "myPrint");
        List<Task> taskList = new ArrayList<Task>(){{add(task1); add(task2); add(task3); add(task4); add(task5);}};

        Gson gson = new Gson();
        String json = gson.toJson(taskList, Task.class);

        Log.d("JSON", json);

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_tasks, R.id.nav_apunts, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public static String fromTaskToString(Task task) {
        Date date = task.getDate();
        String s = String.format("%1;%2;%3;%4;%5",
                task.getNom(), task.getAssignatura(), date.getYear(), date.getMonth(), date.getDate());
        return s;
    }

    public static Task getTaskFromString(String txtString) {
        String[] parts = txtString.split(";");
        return new Task(parts[0], parts[1], new Date(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4])));
    }
}