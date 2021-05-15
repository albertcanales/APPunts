package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    static MyApuntsActivity myActivity;

    static RecyclerView recyclerViewApunts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apunts);

        myActivity = this;

        recyclerViewApunts = findViewById(R.id.apuntsRecyclerView);
        recyclerViewApunts.setHasFixedSize(true);
        recyclerViewApunts.setLayoutManager(new LinearLayoutManager(this));

        List<Apunt> apunts = new ArrayList() {{
            add(new Apunt("Apunts 1", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 2", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 3", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 4", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 5", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 6", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8), false));
        }};

        myApunts = new ApuntsCollection(apunts);
        setAdapter(myApunts);
        findViewById(R.id.pujar_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myActivity, NewApuntActivity.class));
            }
        });

    }

    public static class DeleteApunt implements View.OnClickListener {

        Apunt apunt;

        public DeleteApunt(Apunt apunt) {
            this.apunt = apunt;
        }

        @Override
        public void onClick(View v) {

            final AlertDialog.Builder builder = new AlertDialog.Builder(myActivity);
            builder.setMessage("Delete it permanently?")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            myApunts.remove(apunt);
                            setAdapter(myApunts);
                        }
                    })
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            builder.create().show();

        }
    }

    private static void setAdapter(ApuntsCollection myApunts) {
        recyclerViewApunts.setAdapter(new MyApuntsAdapter(myApunts, myActivity));
    }
    
}