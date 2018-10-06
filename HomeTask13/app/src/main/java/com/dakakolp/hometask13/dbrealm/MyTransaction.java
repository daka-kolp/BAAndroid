package com.dakakolp.hometask13.dbrealm;

import com.dakakolp.hometask13.classes.User;

import io.realm.Realm;

class MyTransaction implements Realm.Transaction {
    @Override
    public void execute(Realm realm) {
        realm.insert(new User("Mila", "K", 23));
        realm.insert(new User("Dmitriy", "W", 27));
        realm.insert(new User("Nina", "Q", 16));
    }
}
