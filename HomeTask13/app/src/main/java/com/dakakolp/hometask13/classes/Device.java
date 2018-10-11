package com.dakakolp.hometask13.classes;

import java.util.UUID;

import io.realm.RealmObject;

public class Device extends RealmObject {

    private String idDevice;
    private String nameDevice;

    public Device() {
        this.idDevice = UUID.randomUUID().toString();
    }

    public Device(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public String getIdDevice() {
        return idDevice;
    }
}

