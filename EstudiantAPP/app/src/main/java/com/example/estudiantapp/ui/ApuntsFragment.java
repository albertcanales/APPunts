package com.example.estudiantapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudiantapp.Biblioteca;
import com.example.estudiantapp.NewTaskActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.FragmentApuntsBinding;

public class ApuntsFragment extends Fragment {

    private FragmentApuntsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentApuntsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.biblioteca).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Biblioteca.class));
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