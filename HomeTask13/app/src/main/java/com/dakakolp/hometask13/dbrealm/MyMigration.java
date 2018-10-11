package com.dakakolp.hometask13.dbrealm;

import com.dakakolp.hometask13.classes.Device;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

class MyMigration implements RealmMigration {
    @Override//DynamicRealm real - бд в которой меняем поля
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();
        if(oldVersion == 0) {

            schema.create("Device")
                    .addField("idDevice", String.class)
                    .addField("nameDevice", String.class);
            schema.get("User")
                    .addField("email", String.class)
                    .addField("phone", String.class)
                    .addRealmObjectField("device", schema.get("Device"));
            oldVersion++;
            //все измененния по второй версии, изменить
        }
    }
}
