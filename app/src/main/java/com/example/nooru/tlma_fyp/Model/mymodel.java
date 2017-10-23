package com.example.nooru.tlma_fyp.Model;

import android.app.Activity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nooru on 10/12/2017.
 */

public class mymodel extends Activity {


    private static final String TAG =firebaseDB.class.getSimpleName();
    FirebaseApp tlmafyp=FirebaseApp.getInstance();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public DatabaseReference myRef;


    public void mymodel(FirebaseDatabase database, FirebaseApp tlmafyp,DatabaseReference myRef) {

        this.database=database;
        this.tlmafyp=tlmafyp;
        this.myRef=myRef;



    }
}
