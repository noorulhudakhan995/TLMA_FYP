package com.example.nooru.tlma_fyp.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.nooru.tlma_fyp.R;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class taskslistactivity extends AppCompatActivity  {
    FirebaseApp tlmafyp=FirebaseApp.getInstance();

    FirebaseDatabase database1 = FirebaseDatabase.getInstance();

// private DatabaseReference myRef=database1.getReference().child("tasks");
DatabaseReference myRef=database1.getReference().child("tasks").child("tasks");



    private ArrayList<String> Tasks=new ArrayList<>();
    private ListView mlistview;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskslistactivity);

        mlistview=(ListView) findViewById(R.id.listView1);

     final   ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Tasks);
        mlistview.setAdapter(arrayAdapter);
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                String value=dataSnapshot.getValue(String.class).toString();
                Tasks.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
