package com.example.hangout.RetrofitLib;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;



public interface ApiInterface {
    @POST("/WebApi/GetLogin")
    Call<JSONObject> GetLogin(@Query("Obj") String Obj);
}
