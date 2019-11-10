package com.example.hangout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        setContentView(R.layout.activity_sign_up);
    }

    public void SignIn(View view) {

        Intent i=new Intent(SignUp.this,MainActivity.class);
        startActivity(i);
        this.finish();
    }
}
