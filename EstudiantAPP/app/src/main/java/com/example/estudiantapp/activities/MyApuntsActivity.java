package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.db.ApuntsHandler;
import com.example.estudiantapp.ui.MyApuntsAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MyApuntsActivity extends AppCompatActivity {

    static MyApuntsActivity myActivity;

    static String USER;

    static RecyclerView recyclerViewApunts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apunts);
        myActivity = this;

        List<String> authors = ApuntsHandler.getApunts().getAuthors();
        Random random = new Random();

        USER = authors.get(random.nextInt(authors.size()-1));

        recyclerViewApunts = findViewById(R.id.apuntsRecyclerView);
        recyclerViewApunts.setHasFixedSize(true);
        recyclerViewApunts.setLayoutManager(new LinearLayoutManager(this));

        setAdapter(ApuntsHandler.getApunts().getApuntsOfAuthor(USER));
        findViewById(R.id.pujar_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myActivity, NewApuntActivity.class));
            }
        });

        findViewById(R.id.regal_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(myActivity, RewardActivity.class));
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
                            ApuntsHandler.remove(apunt, myActivity);
                            setAdapter(ApuntsHandler.getApunts().getApuntsOfAuthor(USER));
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