package com.example.apiconsumer.Interfaces;

import com.example.apiconsumer.modelo.personajes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface inter {
    @GET("characters/{id}")
    Call<personajes> consultar(@Path("id") String id);

}
