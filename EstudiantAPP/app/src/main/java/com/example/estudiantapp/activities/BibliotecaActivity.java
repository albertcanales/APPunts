package com.example.estudiantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.estudiantapp.databinding.ActivityBibliotecaBinding;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.db.ApuntsHandler;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiantapp.ui.SectionsPagerAdapter;

public class BibliotecaActivity extends AppCompatActivity {

    private ActivityBibliotecaBinding binding;

    public ApuntsCollection filteredApunts;

    ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter;
    static BibliotecaActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBibliotecaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent i = getIntent();
        String grau = i.getStringExtra("GRAU");
        String subject = i.getStringExtra("ASSIGNATURA");

        Log.d("APUNTS", grau+subject);
        filteredApunts = ApuntsHandler.getApunts().getApuntsOfDegree(grau).getApuntsOfSubject(subject);

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
}