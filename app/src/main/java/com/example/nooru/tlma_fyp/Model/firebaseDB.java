package com.example.nooru.tlma_fyp.Model;

import android.support.v7.app.AppCompatActivity;


/**
 * Created by nooru on 10/4/2017.
 */

public class firebaseDB  extends AppCompatActivity{
   /*  protected DatabaseReference  myRef;
    protected FirebaseDatabase database ;
    private static final String TAG =firebaseDB.class.getSimpleName();
    protected void onCreates()
    {        FirebaseApp tlmafyp=FirebaseApp.getInstance();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

         database = FirebaseDatabase.getInstance();

      myRef = database.getReference("users");
        myRef = database.getReference("Tasks");
        myRef.child("users").setValue("Name ");
        myRef.child("users").setValue("email ");
        myRef.child("Tasks").setValue("Name");


        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.e(TAG ,"Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Failed to read value
                Log.e(TAG, "Failed to read value.",databaseError.toException());
            }

        });


    }*/

}