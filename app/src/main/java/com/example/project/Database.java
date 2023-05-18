package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper{

    public Database(@Nullable Context context,@Nullable String name ,@Nullable SQLiteDatabase.CursorFactory factory , int version ){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username text,password text,email text,Name text)");
        MyDB.execSQL("create table details(username text,account_no numeric,balance numeric)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {

    }


    public int signup_insert(String username,String password,String email,String name){
        int exist=0;
        String str[]= new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from users where username = ? and password = ?",str);
        if(c.moveToFirst())
        {
            exist=1;
        }
        else {
            ContentValues contentValues=new ContentValues();
            contentValues.put("username",username);
            contentValues.put("password",password);
            contentValues.put("email",email);
            contentValues.put("name",name);
            MyDB.insert("users",null,contentValues);
            MyDB.close();
        }
        return exist;
    }



    public void details_insert(String username,String account_no,double balance){

        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("account_no",account_no);
        contentValues.put("balance",balance);
        SQLiteDatabase MyDB = getWritableDatabase();
        MyDB.insert("details",null,contentValues);
        MyDB.close();
    }

    public int account_no_check(int  account_no)
    {
        int result = 0;
        String str[] = new String[1];
        str[0]=Integer.toString(account_no);
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from details where account_no=?",str);
        if(c.moveToFirst())
        {
            result=1;
        }
        return result;
    }


    public int login(String username, String password)
    {
        int result = 0;
        String str[]= new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from users where username = ? and password = ?",str);
        if(c.moveToFirst())
        {
            result=1;
        }

        return result;
    }

}
