package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;

public class ApuntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apunt);

        Intent i = getIntent();
        Apunt apunt = (Apunt)i.getSerializableExtra("APUNT");

        Log.d("APUNT", apunt.toString());
    }
}