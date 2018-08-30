package com.dakakolp.hometask6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String surname;
    private int age;

    public static List<User> createUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("Mila", "K", 23));
        users.add(new User("Dmitriy", "W", 27));
        users.add(new User("Nina", "Q", 16));
        users.add(new User("Valeriy", "X", 30));
        users.add(new User("Mark", "L", 32));
        users.add(new User("Nikolay", "H", 26));
        return users;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
