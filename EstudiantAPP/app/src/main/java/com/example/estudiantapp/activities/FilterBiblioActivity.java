package com.example.estudiantapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.estudiantapp.R;

public class FilterBiblioActivity extends AppCompatActivity {

    Context context;

    EditText universitat_et;
    EditText grau_et;
    EditText assignatura_et;


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
                    intent.putExtra("UNIVERSITAT", universitat_et.getText());
                    intent.putExtra("GRAU", grau_et.getText());
                    intent.putExtra("ASSIGNATURA", assignatura_et.getText());
                    startActivity(intent);
                }
                else Toast.makeText(context, "Invalid input", Toast.LENGTH_SHORT).show();
            }
        });

        universitat_et = findViewById(R.id.universitat_et);
        grau_et = findViewById(R.id.grau_et);
        assignatura_et = findViewById(R.id.assignatura_et);
    }

    boolean validInput() {
        return true;
    }
}