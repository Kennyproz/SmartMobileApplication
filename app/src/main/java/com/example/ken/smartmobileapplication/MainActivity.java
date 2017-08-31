package com.example.ken.smartmobileapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    protected void clicked(View view){
        System.out.println("Op de knop geklikt");
        System.out.println(i);
        i++;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
