package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account_details extends AppCompatActivity {

    Button id_back_5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
        String a_username = sharedPreferences.getString("username","").toString();
        int balance = sharedPreferences.getInt("balance",0);
        String a_balance = Integer.toString(balance);
        String a_name = sharedPreferences.getString("name","");
        String a_email = sharedPreferences.getString("email","");
        String a_account_no = sharedPreferences.getString("account_no","");

        TextView textView = (TextView) findViewById(R.id.name_show);
        textView.setText(a_name);
        TextView textView1 = (TextView)findViewById(R.id.balance_show);
        textView1.setText(a_balance);
        TextView textView2 = (TextView)findViewById(R.id.email_show);
        textView2.setText(a_email);
        TextView textView3 = (TextView)findViewById(R.id.account_show);
        textView3.setText(a_account_no);
        TextView textView4 = (TextView)findViewById(R.id.username_show);
        textView4.setText(a_username);


        id_back_5=findViewById(R.id.back_5);
        id_back_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Account_details.this,Banking.class));
            }
        });
    }
}