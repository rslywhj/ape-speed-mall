package com.tjetc.service.entity;

public class First {
    private int first_id;
    private String first_name;

    public int getFirst_id() {
        return first_id;
    }

    public void setFirst_id(int first_id) {
        this.first_id = first_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public First() {
    }

    public First(int first_id, String first_name) {
        this.first_id = first_id;
        this.first_name = first_name;
    }
}
