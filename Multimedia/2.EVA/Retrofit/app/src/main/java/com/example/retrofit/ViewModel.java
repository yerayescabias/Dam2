package com.example.retrofit;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends AndroidViewModel {
    MutableLiveData<Kanye.Response> responseMutableLiveData = new MutableLiveData<>();

    public ViewModel(@NonNull Application application) {
        super(application);
    }
    public void Text(){
        Kanye.api.getQuote().enqueue(new Callback<Kanye.Response>() {
            @Override
            public void onResponse(@NonNull Call<Kanye.Response> call, @NonNull Response<Kanye.Response> response) {
                responseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Kanye.Response> call, @NonNull Throwable t) {
                Log.d("onFailure","Error on connection");
            }
        });
    }
}
