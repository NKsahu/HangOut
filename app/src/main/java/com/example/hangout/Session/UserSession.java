package com.example.hangout.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSession  {

    private SharedPreferences Sp;
private SharedPreferences.Editor editor;
   public UserSession(Context ctx){
       Sp=ctx.getSharedPreferences("UserSession",Context.MODE_PRIVATE);
       editor=Sp.edit();
   }
public void SetMobileNo(String Mobile){
     editor.putString("MobilNo",Mobile);
}

public void SetPass(String Password){
        editor.putString("Pass",Password);
   }
    public void SetName(String Name){
        editor.putString("Name",Name);
    }
    public void SetUserCode(String Code){
        editor.putString("UserCode",Code);
    }

    public void Commite(){
       editor.commit();
    }

    public String GetUserCode(){
       return  Sp.getString("UserCode",null);
    }
}
