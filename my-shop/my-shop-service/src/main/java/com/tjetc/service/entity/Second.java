package com.tjetc.service.entity;

public class Second {
    private  int second_id;
    private String second_name;

    public Second() {
    }

    public int getSecond_id() {
        return second_id;
    }

    public void setSecond_id(int second_id) {
        this.second_id = second_id;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public Second(int second_id, String second_name) {
        this.second_id = second_id;
        this.second_name = second_name;
    }
}
