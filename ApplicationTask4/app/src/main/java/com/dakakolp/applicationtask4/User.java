package com.dakakolp.applicationtask4;

public class User {
    private int avatarId;
    private String firstName;
    private String lastName;

    public User(int avatarId, String firstName, String lastName) {
        this.avatarId = avatarId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
