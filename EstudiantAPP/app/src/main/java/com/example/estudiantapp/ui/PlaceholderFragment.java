package com.example.estudiantapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.activities.BibliotecaActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.db.Apunt;
import com.example.estudiantapp.db.ApuntsCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.estudiantapp.ui.SectionsPagerAdapter.RESUM_TAB;
import static com.example.estudiantapp.ui.SectionsPagerAdapter.TEORIA_TAB;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private BibliotecaActivity myActivity;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        int tabPosition = requireArguments().getInt(ARG_SECTION_NUMBER);
        Log.d("TAB", String.valueOf(tabPosition));
        View root = inflater.inflate(R.layout.fragment_assignatura, container, false);

        RecyclerView recyclerViewElements = root.findViewById(R.id.apuntsRecyclerView);
        recyclerViewElements.setHasFixedSize(true);
        recyclerViewElements.setLayoutManager(new LinearLayoutManager(getContext()));

        myActivity = (BibliotecaActivity) requireActivity();

        // Just for testing
        List<Apunt> apunts = new ArrayList() {{
            add(new Apunt("Apunts 1", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 2", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 3", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 4", "Duna Tomàs", "Mates", "CD", "Teoria", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 5", "Duna Tomàs", "Mates", "CD", "Laboratori", 52, "", new Date(2021, 6, 8), false));
            add(new Apunt("Apunts 6", "Duna Tomàs", "Mates", "CD", "Resum", 52, "", new Date(2021, 6, 8), false));
        }};
        ApuntsCollection apuntsCollection = new ApuntsCollection(apunts);
        RecyclerView.Adapter adapter;

        if (tabPosition == TEORIA_TAB)
            adapter = new ApuntsAdapter(apuntsCollection.getApuntsOfType("Teoria"), myActivity);
        else if (tabPosition == RESUM_TAB)
            adapter = new ApuntsAdapter(apuntsCollection.getApuntsOfType("Resum"), myActivity);
        else
            adapter = new ApuntsAdapter(apuntsCollection.getApuntsOfType("Laboratori"), myActivity);

        recyclerViewElements.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        myActivity.refreshAdapter(requestCode);
    }
}