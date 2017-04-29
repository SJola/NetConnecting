package com.jolasudol.netconnecting;

/**
 * Created by RENT on 2017-04-29.
 */

public class TaskDTO {
    private boolean completed;
    private long id;
    private String value;
    private long user;

    public TaskDTO(boolean completed, long id, String value, long user) {
        this.completed = completed;
        this.id = id;
        this.value = value;
        this.user = user;
    }

    public TaskDTO() {

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

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }
}
