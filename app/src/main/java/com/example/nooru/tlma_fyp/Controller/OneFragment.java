package com.example.nooru.tlma_fyp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nooru.tlma_fyp.R;

/**
 * Created by nooru on 9/22/2017.
 */

public class OneFragment extends Fragment {
  FloatingActionButton btn_addtask;
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1 = inflater.inflate(R.layout.fragment_one, container, false);


        btn_addtask = (FloatingActionButton)view1.findViewById(R.id.fabadd1);

        btn_addtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Add_Task.class);
                getActivity().startActivity(intent);


            }
        });

        return view1;}


             }
