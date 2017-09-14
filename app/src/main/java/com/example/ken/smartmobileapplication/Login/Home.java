package com.example.ken.smartmobileapplication.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ken.smartmobileapplication.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        welcome();

    }

    private void welcome(){
        Intent intent = getIntent();
        String textMessage = intent.getStringExtra(Login.EXTRA_MESSAGE);

        TextView text = (TextView)findViewById(R.id.txtWelcome);
        text.setText("Welcome : "+ textMessage);

        ImageView img = (ImageView)findViewById(R.id.imgView);
        img.setImageResource(R.drawable.kensgym);

    }
}
