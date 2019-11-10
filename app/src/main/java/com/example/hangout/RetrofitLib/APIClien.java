package com.example.hangout.RetrofitLib;
import com.example.hangout.Utils.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClien {
    private static Retrofit retrofit = null;
   public static Retrofit getClient() {
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(ProjectSettings.MainUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;}
}
