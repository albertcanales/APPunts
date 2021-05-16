package com.example.estudiantapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudiantapp.activities.BibliotecaActivity;
import com.example.estudiantapp.activities.MainActivity;
import com.example.estudiantapp.activities.MyApuntsActivity;
import com.example.estudiantapp.activities.FilterBiblioActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.FragmentApuntsBinding;
import com.example.estudiantapp.db.ApuntsCollection;
import com.example.estudiantapp.db.ApuntsHandler;
import com.example.estudiantapp.ui.ApuntsAdapter;
import com.example.estudiantapp.ui.MyApuntsAdapter;

import static com.example.estudiantapp.ui.SectionsPagerAdapter.TEORIA_TAB;

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
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FilterBiblioActivity.class));
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}