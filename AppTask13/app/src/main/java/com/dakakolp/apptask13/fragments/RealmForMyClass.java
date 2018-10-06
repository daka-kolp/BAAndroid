package com.dakakolp.apptask13.fragments;

import com.dakakolp.apptask13.classes.User;

import java.util.List;

import io.realm.Realm;

public class RealmForMyClass {

    private Realm realmDB;

    private void insertUser(User user) { //insert to Db
        realmDB.beginTransaction();
        realmDB.insert(user);
        realmDB.commitTransaction();

//        realmDB.executeTransaction(new Realm.Transaction() { //v.2 insert to Db
//            @Override
//            public void execute(Realm realm) {
//                realm.insert(user);
//            }
//        });
    }

    private void updateUser(User user, String idRealm) {

    }


    private User getUserByName(String userName) {
        realmDB.beginTransaction();
        User user = realmDB
                .where(User.class)//в какой таблице ищем
                .equalTo("name", userName) //соответсвует полю в классе
                .findFirst();//найти первый попавшийся
        realmDB.commitTransaction();
        return user;
    }

    private List<User> getUsers() {

        realmDB.beginTransaction();
        List<User> userList = realmDB
                .where(User.class)
                .findAll();
        realmDB.commitTransaction();
        return userList;
    }

    public void close() {
        realmDB.close();
    }
}
