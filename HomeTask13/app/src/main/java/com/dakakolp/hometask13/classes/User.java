package com.dakakolp.hometask13.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class User extends RealmObject{

    @PrimaryKey
    @Required
    private String idStr;
    private String name;
    private String surname;
    private int age;
    private String email;
    private String phone;

    private Device device;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public User() {
        this.idStr = UUID.randomUUID().toString();
    }

    public User(String name, String surname, int age) {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;

    }

    public User(String name, String surname, int age, String email, String phone) {
        this(name, surname, age);
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String surname, int age, String email, String phone, Device device) {
        this(name, surname, age, email, phone);
        this.device = device;
    }

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

    public String getIdStr() {
        return idStr;
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
