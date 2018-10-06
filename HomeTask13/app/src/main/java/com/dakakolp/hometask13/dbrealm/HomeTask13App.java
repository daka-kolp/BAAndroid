package com.dakakolp.hometask13.dbrealm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class HomeTask13App extends Application {

    public static final String DATABASE_NAME = "myhomerealm.realm";

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name(DATABASE_NAME) //имя бд
                .schemaVersion(0) //версия бд
                .migration(new MyMigration())
                .initialData(new MyTransaction())
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
