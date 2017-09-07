package com.example.ken.smartmobileapplication.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ken.smartmobileapplication.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void register(View v){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}
