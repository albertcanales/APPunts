package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudiantapp.R;
import com.example.estudiantapp.db.ApuntsHandler;

public class FilterBiblioActivity extends AppCompatActivity {

    Context context;

    AutoCompleteTextView grau_et;
    AutoCompleteTextView assignatura_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filterbiblio);

        context = this;

        Button buscar_bt = findViewById(R.id.buscar_bt);
        buscar_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validInput()) {
                    Intent intent = new Intent(context, BibliotecaActivity.class);
                    intent.putExtra("GRAU", grau_et.getText().toString());
                    intent.putExtra("ASSIGNATURA", assignatura_et.getText().toString());
                    startActivity(intent);
                }
                else Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
            }
        });

        grau_et = findViewById(R.id.grau_et);
        grau_et.setThreshold(1);
        grau_et.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
                ApuntsHandler.getApunts().getDegrees()));
        assignatura_et = findViewById(R.id.assignatura_et);
        assignatura_et.setThreshold(1);
        assignatura_et.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,
                ApuntsHandler.getApunts().getSubjects()));
    }

    boolean validInput() {
        return true;
    }
}