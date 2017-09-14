package com.example.ken.smartmobileapplication.Login;

/**
 * Created by Ken on 7-9-2017.
 */

public class User {
    private String name,username,password,email;

    public User(String name, String username, String password, String email) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public boolean login (String username, String password){
        if (this.username.equals(username) && this.password.equals(password))
        {
            return true;
        }
        else {
            return false;
        }
    }


}
