package com.example.estudiantapp.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.ActivityMainBinding;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.db.ApuntsHandler;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    MainActivity context;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public ApuntsCollection apuntsFavourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = this;

        ApuntsHandler.create(context, getResources().getString(R.string.default_apunts));
        ApuntsHandler.restore(context);

        //ApuntsHandler.create(context, getResources().getString(R.string.default_apunts));
        ApuntsHandler.restore(context);

        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_tasks, R.id.nav_apunts)
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
        menu.findItem(R.id.load_data).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ApuntsHandler.create(context, getResources().getString(R.string.default_apunts));
                ApuntsHandler.restore(context);
                Log.d("ARXIUS", String.valueOf(ApuntsHandler.isFilePresent(context)));
                Log.d("ARXIUS", ApuntsHandler.getApunts().toString());
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}