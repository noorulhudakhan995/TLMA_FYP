package com.example.nooru.tlma_fyp.Model;

/**
 * Created by nooru on 10/15/2017.
 */

public class Task {

    private String task_name;
    private String task_desc;
    public String task_id;
public String lat;
    public String longit;
        public Task()
        {}


        public Task(String task_id,String task_name,String task_desc,String lat,String longit) {
            this.task_name = task_name;
            this.task_desc = task_desc;
            this.task_id = task_id;
            this.lat = lat;
            this.longit = longit;
        }

    public Task(String task_id) {
        this.task_id=task_id;
    }

    public void setTask(String task_id,String task_name,String task_desc,String lat,String longit)
    { this.task_name = task_name;
        this.task_desc = task_desc;
        this.task_id = task_id;
        this.lat = lat;
        this.longit = longit;
    }
    public String getTask() {

        return task_name;
    }
    public String getTask_desc() {

        return task_desc;
    }
    public String lat() {

        return lat;
    }
    public String getLongit() {

        return longit;
    }
}


