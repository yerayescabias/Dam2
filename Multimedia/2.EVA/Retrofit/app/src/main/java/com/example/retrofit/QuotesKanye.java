package com.example.retrofit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.retrofit.databinding.FragmentQuotesKanyeBinding;

import java.util.Random;


public class QuotesKanye extends Fragment {

    public FragmentQuotesKanyeBinding databinding;
    public Random random = new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return FragmentQuotesKanyeBinding.inflate(inflater,container,false).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        databinding.button.setOnClickListener(click->{
            viewModel.responseMutableLiveData.observe(getViewLifecycleOwner(),
                    new Observer<Kanye.Response>() {
                        @Override
                        public void onChanged(Kanye.Response response) {
                            databinding.textView.setText(response.quote);
                        }

                    });
        });
    }
}