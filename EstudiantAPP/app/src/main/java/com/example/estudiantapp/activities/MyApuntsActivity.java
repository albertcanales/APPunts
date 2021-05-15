package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.ui.MyApuntsAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyApuntsActivity extends AppCompatActivity {

    static ApuntsCollection myApunts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apunts);

        RecyclerView recyclerViewElements = findViewById(R.id.apuntsRecyclerView);
        recyclerViewElements.setHasFixedSize(true);
        recyclerViewElements.setLayoutManager(new LinearLayoutManager(this));

        List<Apunt> apunts = new ArrayList() {{
            add(new Apunt("Apunts 1", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8)));
            add(new Apunt("Apunts 2", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8)));
            add(new Apunt("Apunts 3", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8)));
            add(new Apunt("Apunts 4", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8)));
            add(new Apunt("Apunts 5", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8)));
            add(new Apunt("Apunts 6", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8)));
        }};

        myApunts = new ApuntsCollection(apunts);
        RecyclerView.Adapter adapter = new MyApuntsAdapter(myApunts, this);
        recyclerViewElements.setAdapter(adapter);

    }

    public static class DeleteApunt implements View.OnClickListener {

        Apunt apunt;

        public DeleteApunt(Apunt apunt) {
            this.apunt = apunt;
        }

        @Override
        public void onClick(View v) {
            // TODO Falta poder borrar coses
            myApunts.remove(apunt);
        }
    }
    
}