package com.example.ken.smartmobileapplication.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ken.smartmobileapplication.BasicAppPOC.MainActivity;
import com.example.ken.smartmobileapplication.BasicAppPOC.SecondActivity;
import com.example.ken.smartmobileapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.ken.smartmobileapplication.MESSAGE";
    List<User> users;
    boolean isLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        users = new ArrayList<User>();
        addUsers();
        isLoggedIn = false;
    }

    public void register(View v){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void login(View v)
    {
        EditText un = (EditText)findViewById(R.id.tbUsername);
        EditText ps = (EditText)findViewById(R.id.tbPassword);
        String username = un.getText().toString();
        String password = ps.getText().toString();
       if (!username.isEmpty() && !password.isEmpty()){
            for (User u : users){
              if(u.login(username,password)){
                  Intent intent = new Intent(this, Home.class);
                  String textMessage = username;
                  intent.putExtra(EXTRA_MESSAGE,textMessage);

                  startActivity(intent);
                  isLoggedIn = true;
                  break;
              }
            }
           if (isLoggedIn) {
               Toast.makeText(Login.this,"Logged in!",Toast.LENGTH_LONG).show();
           }
           else {
               Toast.makeText(Login.this,"Login Failed!",Toast.LENGTH_LONG).show();
           }


       }
       else {
           Toast.makeText(Login.this,"Username or password is empty!",Toast.LENGTH_LONG).show();
       }
    }

    private void addUsers(){
        users.add(new User("Ken","Ken","test","Kenny@Hotmail.com"));
        users.add(new User("Marcel","Marcel","test","Marcel@Hotmail.com"));
        users.add(new User("Arjan","Arjan","test","Arjan@Hotmail.com"));
        users.add(new User("Ken","Kennyboy","test","Kenny@Hotmail.com"));
    }
    private void saveCredentials(){
        CheckBox credentials = (CheckBox)findViewById(R.id.chkCredent);
        if (credentials.isActivated()){

        }
        else {
            return;
        }
    }
}
