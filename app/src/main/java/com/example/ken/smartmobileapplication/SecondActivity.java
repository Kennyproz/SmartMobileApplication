package com.example.ken.smartmobileapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String textMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView text = (TextView)findViewById(R.id.textViewSecond);
        text.setText(textMessage);
    }

}
