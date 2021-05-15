package com.example.estudiantapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.Button;

<<<<<<< Updated upstream:EstudiantAPP/app/src/main/java/com/example/estudiantapp/activities/MainActivity.java
import com.example.estudiantapp.R;
import com.google.android.material.snackbar.Snackbar;
=======
import com.example.estudiantapp.databinding.FragmentTasquesBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
>>>>>>> Stashed changes:EstudiantAPP/app/src/main/java/com/example/estudiantapp/MainActivity.java
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiantapp.databinding.ActivityMainBinding;

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