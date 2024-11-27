package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class Kanye {
    class Response{
        List<Content>results;
    }
    class Content {
         String quote;
    }
    public interface API{
        @GET("/")
        Call<Response>getQuote();
    }
    public static API api = new Retrofit.Builder().baseUrl("https://api.kanye.rest").
            addConverterFactory(GsonConverterFactory.create()).build().create(API.class);
}
