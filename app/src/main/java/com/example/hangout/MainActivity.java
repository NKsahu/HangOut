package com.example.hangout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.hangout.Session.*;
import com.example.hangout.RetrofitLib.APIClien;
import com.example.hangout.RetrofitLib.ApiInterface;
import java.lang.String;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText MobileNo,Password;
    Button LoginBtn;
    String Mobile=null;
    String Pass=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_out, R.anim.slide_in);
        setContentView(R.layout.activity_main);
        MobileNo=findViewById(R.id.Mobileno);
        Password=findViewById(R.id.Pass);
        LoginBtn=findViewById(R.id.LoginBtn);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }


    public void SignIn(){
        Mobile=MobileNo.getText().toString();
        Pass=Password.getText().toString();
if(Mobile==null|| Mobile.equalsIgnoreCase("")){
    MobileNo.setError("Please Enter Mobile No First");
    return;
}
        if(Pass==null|| Pass.equalsIgnoreCase("")){
            Password.requestFocus();
            Password.setError("Field Mandatory");
            return;

        }
        else {
            try {
                CheckLogin();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public void SignUp(View view){
        Intent i=new Intent(MainActivity.this,SignUp.class);
        startActivity(i);
        this.finish();
    }

    public void CheckLogin() throws JSONException {

        ApiInterface apiInterface= APIClien.getClient().create(ApiInterface.class);
        JSONObject Obj=new JSONObject();
        Obj.put("UserId",Mobile);
        Obj.put("Password",Pass);
        Call<JSONObject> JsonLogin=apiInterface.GetLogin(Obj.toString());
        String Url=JsonLogin.request().url().toString();
        JsonLogin.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {

                Log.d("Result",response.body().toString());

                UserSession userSession=new UserSession(MainActivity.this);
                //userSession.SetName(response.body().);
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.d("Result","Error");
            }
        });

    }
}
