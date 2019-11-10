package com.example.hangout.RetrofitLib;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ApiInterface {
    @POST("/WebApi/GetLogin")
    Call<Object> GetLogin(@Query("Obj") String Obj);
}
