package com.example.estudiantapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudiantapp.activities.MainActivity;
import com.example.estudiantapp.activities.NewTaskActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.FragmentTasquesBinding;

public class TasquesFragment extends Fragment {

    private FragmentTasquesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTasquesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.new_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NewTaskActivity.class));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}