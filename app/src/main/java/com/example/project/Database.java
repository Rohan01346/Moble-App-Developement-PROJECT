package com.example.project;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Key;

public class Database extends SQLiteOpenHelper{

    public Database(@Nullable Context context,@Nullable String name ,@Nullable SQLiteDatabase.CursorFactory factory , int version ){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username text,password text,email text,name text)");
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

    public int account_no_check(String account_no)
    {
        int result = 0;
        String str[] = new String[1];
        str[0]=account_no;
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



    public int select_balance(String username)
    {
        int balance1=0;
        String str[]= new String[1];
        str[0]=username;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from details where username = ?",str);
        if(c.moveToFirst())
        {
            balance1 = c.getInt(2);
            Log.v(TAG,"BALANCE"+" "+balance1);
        }
        return balance1;
    }



    public String select_email(String username)
    {
        String email="";
        String str[]= new String[1];
        str[0]=username;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from users where username = ?",str);
        if(c.moveToFirst())
        {
            email = c.getString(2);
            Log.v(TAG,"EMAIL"+" "+email);
        }
        return email;
    }


    public String select_name(String username)
    {
        String name ="";
        String str[]= new String[1];
        str[0]=username;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from users where username = ?",str);
        if(c.moveToFirst())
        {
            name = c.getString(3);
            Log.v(TAG,"NAME"+" "+name);
        }
        return name;
    }

    public String select_account_no(String username)
    {
        String account_no ="";
        String str[]= new String[1];
        str[0]=username;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c = MyDB.rawQuery("select * from details where username = ?",str);
        if(c.moveToFirst())
        {
            account_no = c.getString(1);
            Log.v(TAG,"account_no"+" "+account_no);
        }
        return account_no;
    }


    public int name_account_no_check(String username,String name,String Account_no)
    {
        int result=0;
        String username_get="";
        String str1[]=new String[1];
        String str[]=new String[2];
        str[0]=Account_no;
        str1[0]=name;
        SQLiteDatabase MyDB = getWritableDatabase();
        Cursor c1 = MyDB.rawQuery("select * from users where name = ?",str1);
        if(c1.moveToFirst())
        {
            username_get = c1.getString(0);
            Log.v(TAG,"username_get"+" "+username_get);
        }
        str[1]=username_get;
        Cursor c = MyDB.rawQuery("select * from details where account_no=? and username=?",str);
        if(c.moveToFirst())
        {
            result=1;
        }
        return result;
    }
    public void update_add_amount(int amount , String username)
    {
        int result=0;
        SQLiteDatabase MyDB = getWritableDatabase();
        ContentValues values = new ContentValues();

        int balance1=0;
        String str[]= new String[1];
        String str1[]=new String[1];
        str1[0]=username;
        str[0]=username;
        Cursor c = MyDB.rawQuery("select * from details where username = ?",str);
        if(c.moveToFirst())
        {
            balance1 = c.getInt(2);
            Log.v(TAG,"BALANCE"+" "+balance1);
        }
        values.put("balance",balance1+amount);
        MyDB.update("details",values,"username=?",str1);



    }

    public void update_transaction_amount(int amount , String username , String Account_no)
    {
        int result=0;
        SQLiteDatabase MyDB = getWritableDatabase();
        ContentValues values = new ContentValues();


        int balance1=0;
        int balance2=0;
        String str1[]=new String[1];
        String str2[]=new String[1];

        str1[0]=username;
        str2[0]=Account_no;
        Cursor c = MyDB.rawQuery("select * from details where username = ?",str1);
        if(c.moveToFirst())
        {
            balance1 = c.getInt(2);
            Log.v(TAG,"BALANCE"+" "+balance1);
        }

        Cursor c1 = MyDB.rawQuery("select * from details where account_no = ?",str2);
        if(c1.moveToFirst())
        {
            balance2 = c1.getInt(2);
            Log.v(TAG,"BALANCE"+" "+balance2);
        }

        values.put("balance",balance1-amount);
        MyDB.update("details",values,"username=?",str1);
        values.put("balance",balance2+amount);
        MyDB.update("details",values,"account_no=?",str2);



    }











}
