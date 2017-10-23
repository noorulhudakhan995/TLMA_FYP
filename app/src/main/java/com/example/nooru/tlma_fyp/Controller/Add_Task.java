package com.example.nooru.tlma_fyp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nooru.tlma_fyp.R;

public class Add_Task extends AppCompatActivity {
Button btn_save, btn_cancel,btn_select_location,btn_alarm;
    EditText task_name,task_desc,lat,longit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__task);

        btn_save = (Button)findViewById(R.id.Btn_Save_task);
        btn_cancel = (Button)findViewById(R.id.Btn_cancel);
        btn_select_location = (Button)findViewById(R.id.Btn_Select_location);
        btn_alarm = (Button)findViewById(R.id.Btn_Set_alarm);
        task_name=(EditText)findViewById(R.id.editText_taskname);
        task_desc=(EditText)findViewById(R.id.editText_taskdescrip);
      lat=(EditText)findViewById(R.id.editText_Lat);
        longit=(EditText)findViewById(R.id.editText_Longitude);
        btn_alarm .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TwoFragment.class);
                view.getContext().startActivity(intent);
               finish();


            }
        });
       btn_select_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Add_Task.this,MainActivity.class);
                startActivity(intent);


            }
        });
    }
}
