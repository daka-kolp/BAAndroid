package com.dakakolp.apptask13;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppTask13App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myrealm.realm") //имя бд
                .schemaVersion(1) //версия бд
                .migration(new MyMigration())
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
