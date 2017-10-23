package com.example.nooru.tlma_fyp.Model;

import android.app.Activity;

import com.example.nooru.tlma_fyp.Controller.OneFragment;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by nooru on 10/12/2017.
 */

public class myDBcontroller extends Activity  {
    private static final String TAG = OneFragment.class.getSimpleName();
    mymodel obj1= new mymodel();
    FirebaseApp tlmafyp=FirebaseApp.getInstance();
    FirebaseDatabase database1 = FirebaseDatabase.getInstance();

    public DatabaseReference myRef;

    public myDBcontroller(){

    }
    public void CreateUser(String user_id, String email) {

        obj1.mymodel(database1, tlmafyp, myRef);

        myRef = database1.getReference("users");
        User user = new User(user_id, email);
        myRef.child("users").push().setValue(user);

    }

    public void addtask(String task_id,String task_name, String task_description,String lat,String longit){
        obj1.mymodel(database1,tlmafyp,myRef);
       // String postId = myRef.getKey();
        myRef = database1.getReference("tasks");
        Task one = new Task( task_id,task_name,task_description, lat, longit);
        myRef.child("tasks").setValue(one);


}
    }
