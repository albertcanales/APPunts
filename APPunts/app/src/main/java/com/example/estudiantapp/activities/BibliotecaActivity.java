package com.example.estudiantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.ActivityBibliotecaBinding;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.db.ApuntsHandler;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiantapp.ui.SectionsPagerAdapter;

import java.util.Objects;

public class BibliotecaActivity extends AppCompatActivity {

    private ActivityBibliotecaBinding binding;

    public ApuntsCollection filteredApunts;
    static String grau, subject;

    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    static BibliotecaActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBibliotecaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(findViewById(R.id.toolbar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();

        grau = i.getStringExtra("GRAU");
        subject = i.getStringExtra("ASSIGNATURA");

        Log.d("APUNTS", grau+subject);
        filteredApunts = updateFilteredApunts();

        activity = this;

        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
    }

    public void refreshAdapter(int tabPosition) {
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setCurrentItem(tabPosition, false);
    }

    public static class ChangeToApunt implements View.OnClickListener {

        Apunt apunt;

        public ChangeToApunt(Apunt apunt) {
            this.apunt = apunt;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(activity, ApuntActivity.class);
            intent.putExtra("APUNT", apunt);
            activity.startActivity(intent);
        }
    }

    static ApuntsCollection updateFilteredApunts() {
        Log.d("APUNTS", ApuntsHandler.getApunts().getApuntsOfDegree(grau).getApuntsOfSubject(subject).toString());
        return ApuntsHandler.getApunts().getApuntsOfDegree(grau).getApuntsOfSubject(subject);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}