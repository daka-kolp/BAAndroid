package com.dakakolp.hometask9fixed.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dakakolp.hometask9fixed.classes.User;

import java.util.ArrayList;
import java.util.List;

public class DBOpenHelper extends SQLiteOpenHelper {


    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "newDBApplication";
    private static final String TABLE_USERS = "users";
    private static final String ID = "id";
    private static final String NAME = "nameUser";
    private static final String SURNAME = "surnameUser";
    private static final String AGE = "age";

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_USERS + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT," +
                SURNAME + " TEXT," +
                AGE + " INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //1
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(NAME, user.getName());
        values.put(SURNAME, user.getSurname());
        values.put(AGE, user.getAge());

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    //2
    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,
                ID + " = " + Integer.toString(id),
                null);
        db.close();
    }

    //3
    public void editUser(int id, User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(NAME, user.getName());
        value.put(SURNAME, user.getSurname());
        value.put(AGE, user.getAge());
        db.update(TABLE_USERS, value, ID + " = " + Integer.toString(id), null);
        db.close();
    }

    //4
    public List<User> getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();

        List<User> listUsers = new ArrayList<User>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_USERS, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setIdDB(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setSurname(cursor.getString(2));
                user.setAge(cursor.getInt(3));
                listUsers.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listUsers;
    }

    //5
    public User getUser(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor
                = db.query(TABLE_USERS,
                null,
                ID + " = " + Integer.toString(id),
                null,
                null,
                null,
                null);
        User user = new User();
        if(cursor.moveToFirst()){
            user.setIdDB(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setSurname(cursor.getString(2));
            user.setAge(cursor.getInt(3));
        }
        cursor.close();
        return user;
    }

    //6
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, null, null);
        db.close();
    }


}
