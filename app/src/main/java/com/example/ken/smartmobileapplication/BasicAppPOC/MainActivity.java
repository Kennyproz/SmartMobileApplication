package com.example.ken.smartmobileapplication.BasicAppPOC;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ken.smartmobileapplication.R;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.ken.smartmobileapplication.MESSAGE";
    protected void clicked(View view){
        TextView textView = (TextView)findViewById(R.id.lblText);
        EditText inputText = (EditText)findViewById(R.id.editText);
        if (!inputText.getText().toString().isEmpty()){
            textView.setText(inputText.getText());
            Toast.makeText(MainActivity.this,"Changed text to: " + inputText.getText(),Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Input has no text!",Toast.LENGTH_LONG).show();
        }
    }

    public void showMessage(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText);
        String textMessage = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,textMessage);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




}
