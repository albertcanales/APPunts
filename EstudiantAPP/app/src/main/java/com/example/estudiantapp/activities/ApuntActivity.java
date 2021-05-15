package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;

public class ApuntActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apunt);

        Intent i = getIntent();
        Apunt apunt = (Apunt)i.getSerializableExtra("APUNT");

        Log.d("APUNT", apunt.toMemString());

        ((TextView) findViewById(R.id.tipus_tv)).setText(apunt.getType());
        ((TextView) findViewById(R.id.titol_tv)).setText(apunt.getSubject().concat(" - ").concat(apunt.getDegree()));
        ((TextView) findViewById(R.id.autor_tv)).setText(apunt.getAuthor());

        // ((TextView) findViewById(R.id.descripcio_tv)).setText(apunt.getDescription());
    }
}