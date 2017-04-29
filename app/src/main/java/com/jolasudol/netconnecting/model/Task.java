package com.jolasudol.netconnecting.model;

/**
 * Created by RENT on 2017-04-29.
 */

public class Task {
    boolean completed;
    long id;
    String value;

    public Task(boolean completed, long id, String value) {
        this.completed = completed;
        this.id = id;
        this.value = value;
    }

    public Task(){

    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
