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

import com.example.estudiantapp.activities.AssignaturaActivity;
import com.example.estudiantapp.R;

import static com.example.estudiantapp.ui.SectionsPagerAdapter.LABORATORI_TAB;
import static com.example.estudiantapp.ui.SectionsPagerAdapter.RESUM_TAB;
import static com.example.estudiantapp.ui.SectionsPagerAdapter.TEORIA_TAB;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private AssignaturaActivity myActivity;

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

        RecyclerView recyclerViewElements = root.findViewById(R.id.elementsRecyclerView);
        recyclerViewElements.setHasFixedSize(true);
        recyclerViewElements.setLayoutManager(new LinearLayoutManager(getContext()));

        myActivity = (AssignaturaActivity) requireActivity();



        RecyclerView.Adapter adapter;
        adapter = new TeoriaAdapter(apuntsList, myActivity);
        // TODO Això de sobre no farà falta
        if (tabPosition == RESUM_TAB) {
            adapter = new TeoriaAdapter(apuntsList, myActivity);
        } else if (tabPosition == TEORIA_TAB) {   // ANGLES
            //adapter = new AnglesAdapter(elements, myActivity);
        } else if (tabPosition == LABORATORI_TAB) {
            //adapter = new VectorsAdapter(elements, myActivity);
        }
        recyclerViewElements.setAdapter(adapter);

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        myActivity.refreshAdapter(requestCode);
    }
}