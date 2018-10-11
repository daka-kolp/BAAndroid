package com.dakakolp.hometask13.dbrealm;

import com.dakakolp.hometask13.classes.User;

import java.io.File;
import java.util.List;

import io.realm.Realm;

public class UserDBRealm {

    public static final String ID = "idStr";

    private Realm realmDb;

    public UserDBRealm() {
        this.realmDb = Realm.getDefaultInstance();
    }

    public void insertUser(User user) { //insert to Db
        realmDb.beginTransaction();
        realmDb.insert(user);
        realmDb.commitTransaction();
    }

    public List<User> getUsers() {

        realmDb.beginTransaction();
        List<User> userList = realmDb
                .where(User.class)
                .findAll();
        realmDb.commitTransaction();
        return userList;
    }

    public User getUserById(String idUser) {
        realmDb.beginTransaction();

        User user = realmDb
                .where(User.class)//table
                .equalTo(ID, idUser)
                .findFirst();

        realmDb.commitTransaction();
        return user;
    }


    public void updateUser(final User user, final String name, final String surname, final int age) {
        realmDb.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (user != null) {
                    user.setName(name);
                    user.setSurname(surname);
                    user.setAge(age);
                }
            }
        });
    }


    public void deleteUserById(String idUser) {
        realmDb.beginTransaction();

        User user = realmDb.where(User.class)
                .equalTo(ID, idUser)
                .findFirst();
        if (user != null)
            user.deleteFromRealm();

        realmDb.commitTransaction();
    }

    public void deleteAllUsers() {

        realmDb.beginTransaction();
        realmDb.deleteAll();
        realmDb.commitTransaction();
    }

    public void close() {
        realmDb.close();
    }

}
