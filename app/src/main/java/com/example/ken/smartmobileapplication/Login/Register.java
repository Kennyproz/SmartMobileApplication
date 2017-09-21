package com.example.ken.smartmobileapplication.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ken.smartmobileapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_register);

        Intent intent = getIntent();
        userList = (ArrayList<User>) intent.getSerializableExtra("users");
    }

    public void registerUser(View v){
        EditText username = (EditText)findViewById(R.id.editTextUsername);
        for (User u : userList){
            if (u.getUsername().toString().equals(username.getText().toString())){
                Toast.makeText(Register.this,"Username already in Use!!",Toast.LENGTH_LONG).show();
            }
            else{
                addUser();
                //Intent intent = new Intent(this,Login.class);
                //intent.putExtra("allUsers", (ArrayList<User>)userList);
                //startActivity(intent);
                //Toast.makeText(Register.this,"The user is registered succesfully!",Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
    private void addUser(){
        EditText edUsername = (EditText)findViewById(R.id.editTextUsername);
        EditText edName = (EditText)findViewById(R.id.editTextName);
        EditText edPass1 = (EditText)findViewById(R.id.editTextPass);
        EditText edPass2 = (EditText)findViewById(R.id.editTextpass);
        EditText edEmail = (EditText)findViewById(R.id.editTextEmail);

        String username = edUsername.getText().toString();
        String name = edName.getText().toString();
        String pass = edPass1.getText().toString();
        String pass1 = edPass2.getText().toString();
        String mail = edEmail.getText().toString();

        if (pass.equals(pass1) && !pass.isEmpty()){
            if (username.isEmpty() || name.isEmpty() || mail.isEmpty())
            {
                Toast.makeText(Register.this,"Please fill in all fields!",Toast.LENGTH_LONG).show();
            }
            else {
                User user = new User(name,username,pass,mail);
                userList.add(user);
            }
        }
        else {
            Toast.makeText(Register.this,"Password do not match!!",Toast.LENGTH_LONG).show();
        }
    }


}
