package com.example.ken.smartmobileapplication.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ken.smartmobileapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.ken.smartmobileapplication.MESSAGE";

    List<User> users;
    boolean isLoggedIn;
    EditText un,ps;
    String username,password;
    CheckBox chkbox;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addUsers();
        getIds();
        isLoggedIn = false;

        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String uname = sharedPreferences.getString("Username", null);
        String pass = sharedPreferences.getString("Password",null);

        checkString(uname,un);
        checkString(pass,ps);
    }

    private void checkString(String string, EditText editText){
        if (string != null){
            editText.setText(string);
        }
        else {
            return;
        }
    }

    public void register(View v){
        Intent intent = new Intent(this,Register.class);
        intent.putExtra("users", (ArrayList<User>)users);
        startActivity(intent);
    }

    public void login(View v)
    {
        getIds();
        getInlogStrings();
        if (!username.isEmpty() && !password.isEmpty()){
            for (User u : users){
              if(u.login(username,password)){
                  Intent intent = new Intent(this, Home.class);
                  String textMessage = username;
                  intent.putExtra(EXTRA_MESSAGE,textMessage);
                  isLoggedIn = true;
                  saveCredentials();
                  startActivity(intent);
                  break;
              }
            }
           isLoggedIn();
       }
       else {
           Toast.makeText(Login.this,"Username or password is empty!",Toast.LENGTH_LONG).show();
       }
    }

    private void addUsers(){
        users = new ArrayList<User>();
        users.add(new User("Ken","Ken","test","Kenny@Hotmail.com"));
        users.add(new User("Marcel","Marcel","test","Marcel@Hotmail.com"));
        users.add(new User("Arjan","Arjan","test","Arjan@Hotmail.com"));
        users.add(new User("Ken","Kennyboy","test","Kenny@Hotmail.com"));
    }
    private void saveCredentials(){
        if (chkbox.isChecked()){
            editor.putString("Username",username);
            editor.putString("Password",password);
            editor.commit();
        }
        else {
            editor.clear().commit();
        }
    }

    private void getIds(){
        un = (EditText)findViewById(R.id.tbUsername);
        ps = (EditText)findViewById(R.id.tbPassword);
        chkbox = (CheckBox)findViewById(R.id.chkCredent);
    }

    private void getInlogStrings(){
        username = un.getText().toString();
        password = ps.getText().toString();
    }

    private void isLoggedIn(){
        if (isLoggedIn) {
            Toast.makeText(Login.this,"Logged in!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(Login.this,"Login Failed!",Toast.LENGTH_LONG).show();
        }
    }
}
