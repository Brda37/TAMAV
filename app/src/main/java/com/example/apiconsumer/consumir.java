package com.example.apiconsumer;

import com.example.apiconsumer.Interfaces.inter;
import com.example.apiconsumer.modelo.personajeFinal;
import com.example.apiconsumer.modelo.personajes;

import java.sql.SQLOutput;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class consumir {

    public static String URL = "https://api.potterdb.com/v1/";
    public static Retrofit retro;

    personajeFinal personajeFinal = new personajeFinal();

    public void resultado(String id){
        retro = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        inter consApi = retro.create(inter.class);

        Call<personajes> call = consApi.consultar(id);

        call.enqueue(new Callback<personajes>() {
            @Override
            public void onResponse(Call<personajes> call, Response<personajes> response) {
                try {
                    if(response.isSuccessful()){
                        personajes personajes = response.body();
                        personajeFinal.setId(personajes.getId());
                        personajeFinal.setBorn(personajes.getBorn());
                        personajeFinal.setGender(personajes.getGender());
                        personajeFinal.setHouse(personajes.getHouse());
                        personajeFinal.setSlug(personajes.getSprites().getSlug());
                    }else {
                        System.out.println("Mal");
                        System.out.println(call);
                    }
                }catch (Exception ex){
                    System.out.println("UWUn't " + ex);
                }
            }

            @Override
            public void onFailure(Call<personajes> call, Throwable t) {
                System.out.println("UWUn't " + t);
            }
        });
    }
}
