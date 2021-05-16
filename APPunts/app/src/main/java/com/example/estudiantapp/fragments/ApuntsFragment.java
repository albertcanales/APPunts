package com.example.estudiantapp.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.activities.BibliotecaActivity;
import com.example.estudiantapp.activities.MainActivity;
import com.example.estudiantapp.activities.MyApuntsActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.FragmentApuntsBinding;
import com.example.estudiantapp.db.ApuntsHandler;
import com.example.estudiantapp.ui.ApuntsAdapter;

public class ApuntsFragment extends Fragment {

    private FragmentApuntsBinding binding;
    private RecyclerView recyclerViewApunts;
    private MainActivity myActivity;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentApuntsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.myapunts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MyApuntsActivity.class));
            }
        });

        root.findViewById(R.id.biblioteca).setOnClickListener(new View.OnClickListener() {

            AutoCompleteTextView grau_et;
            AutoCompleteTextView assignatura_et;

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(myActivity);

                dialog.setContentView(R.layout.dialog_filterbiblio);

                // set the custom dialog components - text, image and button
                Button buscar_bt = dialog.findViewById(R.id.buscar_bt);
                buscar_bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(myActivity, BibliotecaActivity.class);
                        intent.putExtra("GRAU", grau_et.getText().toString());
                        intent.putExtra("ASSIGNATURA", assignatura_et.getText().toString());
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
                dialog.findViewById(R.id.cancel_bt).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                grau_et = dialog.findViewById(R.id.grau_et);
                grau_et.setThreshold(1);
                grau_et.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_dropdown_item_1line,
                        ApuntsHandler.getApunts().getDegrees()));
                assignatura_et = dialog.findViewById(R.id.assignatura_et);
                assignatura_et.setThreshold(1);
                assignatura_et.setAdapter(new ArrayAdapter<String>(myActivity, android.R.layout.simple_dropdown_item_1line,
                        ApuntsHandler.getApunts().getSubjects()));

                int width = (int)(getResources().getDisplayMetrics().widthPixels*0.9);
                int height = (int)(getResources().getDisplayMetrics().heightPixels*0.3);
                dialog.getWindow().setLayout(width, height);

                dialog.show();
            }
        });

        recyclerViewApunts = root.findViewById(R.id.apuntsRecyclerView);
        recyclerViewApunts.setHasFixedSize(true);
        recyclerViewApunts.setLayoutManager(new LinearLayoutManager(getContext()));

        myActivity = (MainActivity) requireActivity();
        myActivity.apuntsFavourites = ApuntsHandler.getApunts().getFavourites();

        RecyclerView.Adapter adapter = new ApuntsAdapter(myActivity.apuntsFavourites, myActivity);
        recyclerViewApunts.setAdapter(adapter);

        return root;
    }

    public void onResume(){
        super.onResume();

        myActivity = (MainActivity) requireActivity();
        myActivity.apuntsFavourites = ApuntsHandler.getApunts().getFavourites();

        RecyclerView.Adapter adapter = new ApuntsAdapter(myActivity.apuntsFavourites, myActivity);
        recyclerViewApunts.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}