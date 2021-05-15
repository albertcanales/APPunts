package com.example.estudiantapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.estudiantapp.db.Task;
import com.example.estudiantapp.db.TxtHandler;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.ActivityMainBinding;

import com.google.android.material.navigation.NavigationView;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import static com.example.estudiantapp.db.TxtHandler.fromTaskListToString;

public class MainActivity extends AppCompatActivity {


    MainActivity context;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        //        Task task1 = new Task("Entregable 4", "CD", new Date(2021, 12, 3));
//        Task task2 = new Task("Entregable 5", "CD", new Date(2021, 12, 3));
//        Task task3 = new Task("Entregable 6", "CD", new Date(2021, 12, 3));
//        Task task4 = new Task("Entregable 7", "CD", new Date(2021, 12, 3));
//        Task task5 = new Task("Entregable 8", "CD", new Date(2021, 12, 3));
//
//        List<Task> taskList = new ArrayList<Task>(){{add(task1); add(task2); add(task3); add(task4); add(task5);}};

        // Gson gson = new Gson();

        // String txt = fromTaskListToString(taskList);

        /*
        try {
            TxtHandler.prova(context, taskList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.newFab.setOnClickListener(new View.OnClickListener() {

            private boolean isFABOpen = false;

            final Button fab_subject = (Button) findViewById(R.id.subject_fab);
            final Button fab_task = (Button) findViewById(R.id.task_fab);

            private void showFABMenu(){
                isFABOpen=true;
                findViewById(R.id.subject_fab).setVisibility(View.VISIBLE);
                findViewById(R.id.task_fab).setVisibility(View.VISIBLE);
                fab_subject.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
                fab_task.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
            }

            private void closeFABMenu(){
                isFABOpen=false;
                findViewById(R.id.task_fab).setVisibility(View.GONE);
                findViewById(R.id.subject_fab).setVisibility(View.GONE);
                fab_task.animate().translationY(0);
                fab_subject.animate().translationY(0);
            }

            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
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
}