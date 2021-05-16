package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsHandler;

public class ApuntActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apunt);

        context = this;

        Intent i = getIntent();
        Apunt apunt = (Apunt)i.getSerializableExtra("APUNT");

        Log.d("FAVOUR", String.valueOf(apunt.getIsFavourite()));
        ImageButton fav_button = findViewById(R.id.fav_menuitem);
        setDrawable(apunt, fav_button);
        fav_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApuntsHandler.changeFavourite(apunt, context);
                apunt.setIsFavourite(!apunt.getIsFavourite());
                BibliotecaActivity.updateFilteredApunts();
                setDrawable(apunt, fav_button);
                Log.d("FAVOUR", String.valueOf(apunt.getIsFavourite()));

            }
        });

        Log.d("APUNT", apunt.toMemString());

        ((TextView) findViewById(R.id.tipus_tv)).setText(apunt.getType());
        ((TextView) findViewById(R.id.titol_tv)).setText(apunt.getSubject().concat(" - ").concat(apunt.getDegree()));
        ((TextView) findViewById(R.id.autor_tv)).setText(apunt.getAuthor());
        ((TextView) findViewById(R.id.descripcio_tv)).setText(apunt.getDescription());
    }

    void setDrawable(Apunt apunt, ImageButton fav_button) {
        if(apunt.getIsFavourite())
            fav_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_star_24));
        else
            fav_button.setImageDrawable(getResources().getDrawable(R.drawable.ic_baseline_star_border_24));
    }
}