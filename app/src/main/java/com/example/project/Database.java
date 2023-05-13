package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class Database extends SQLiteOpenHelper{

    public static final String DBNAME = "Login.db";

    public Database(Context context){
        super(context, "Login.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username varchar(10) primary key,password varchar(50),email varchar(50),Name varchar(50))");
        MyDB.execSQL("create table details(username varchar(10),accountno numeric,balance numeric)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

    }
    private SQLiteDatabase getWriteableDatabase() {
        return null;
    }
    public Boolean insertData(String username,String password,String email,String name){
        SQLiteDatabase MyDB=this.getWriteableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("email",email);
        contentValues.put("name",name);
        long result =MyDB.insert("users",null,contentValues);
        if(result==-1) return false;
        else
            return true;
    }



}
