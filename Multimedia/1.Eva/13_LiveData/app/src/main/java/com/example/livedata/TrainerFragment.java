package com.example.livedata;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.livedata.databinding.FragmentTrainerBinding;

public class TrainerFragment extends Fragment {
    private FragmentTrainerBinding bd;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (bd = FragmentTrainerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TrainerViewModel trainerViewModel = new ViewModelProvider(this).get(TrainerViewModel.class);

        trainerViewModel.getExercise().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer exercise) {
                Glide.with(TrainerFragment.this).load(exercise).into(bd.exercise);
            }
        });

        trainerViewModel.getRepetition().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String repetition) {
                if(repetition.equals("CHANGE")){
                    bd.change.setVisibility(View.VISIBLE);
                } else {
                    bd.change.setVisibility(View.GONE);
                }
                bd.repetition.setText(repetition);
            }
        });
    }
}