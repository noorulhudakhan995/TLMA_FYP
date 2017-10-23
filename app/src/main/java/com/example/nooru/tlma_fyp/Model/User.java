package com.example.nooru.tlma_fyp.Model;

/**
 * Created by nooru on 10/9/2017.
 */

public class User {
    public String name;
    public String email;
    public String user_id;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User( String user_id,String email) {
       // this.name = name;
        this.email = email;
        this.user_id = user_id;
    }
    private void SetUser(String user_id, String email) {
       // this.name = name;
        this.email = email;
        this.user_id = user_id;

    }



    public String getname() {

        return  name;
    }
    public String getemail() {

        return  email;
    }}