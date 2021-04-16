package com.example.apecsapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class ProfilesDataSQLHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Profiles.db";
    private static final int DATABASE_VERSION=1;
    public static final String TABLE="profiles";
    public static final String NAME="name";
    public static final String AGE="age";
    public static final String DIAGNOSIS="diagnosis";
    public static final String EMAIL="email";
    public static final String PASSWORD="password";
    public ProfilesDataSQLHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql= "create table " + TABLE + "(" + BaseColumns._ID + " integer primary key autoincrement, " + NAME + " text not null, " + AGE + " integer, " + DIAGNOSIS + " text not null, " + EMAIL + " text not null, " + PASSWORD +  " text not null);";
        db.execSQL(sql);
        Log.d(TAG, "Database tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }
    public void addUser(String name, String age, String diagnosis, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(AGE, age);
        values.put(DIAGNOSIS, diagnosis);
        values.put(EMAIL, email);
        values.put(PASSWORD, password);
        long id = db.insert(TABLE, null, values);
        db.close();
        Log.d(TAG, "New user inserted into sqlite: " + id);
    }
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        String selectQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(1));
            user.put("age", cursor.getString(2));
            user.put("diagnosis", cursor.getString(3));
            user.put("email", cursor.getString(4));
            user.put("password",cursor.getString(5));
        }
        cursor.close();
        db.close();
        Log.d(TAG, "Fetching user from Sqlite: " + user.toString());
        return user;
    }
    public void deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows
        db.delete(TABLE, null, null);
        db.close();
        Log.d(TAG, "Deleted all user info from sqlite");
    }

}
