package com.example.estudiantapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudiantapp.NewTaskActivity;
import com.example.estudiantapp.R;
import com.example.estudiantapp.databinding.FragmentTasquesBinding;

public class TasquesFragment extends Fragment {

    private FragmentTasquesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTasquesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.newtask_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.println(Log.ASSERT, "JAJA", "lol");
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