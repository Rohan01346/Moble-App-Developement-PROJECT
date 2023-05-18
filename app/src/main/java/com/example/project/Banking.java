package com.example.project;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import kotlinx.coroutines.flow.SharedFlow;

public class Banking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_username", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Welcome"+" "+username,Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_banking);

        CardView add_money =  findViewById(R.id.button1);
        CardView account_details =  findViewById(R.id.button2);
        CardView send_money =  findViewById(R.id.button3);
        CardView loan_checker =  findViewById(R.id.button4);
        CardView about_us=  findViewById(R.id.button5);
        CardView logout =  findViewById(R.id.button6);
        add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Banking.this,Add_money.class));
            }
        });

        account_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Banking.this,Account_details.class));
            }
        });

        send_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Banking.this,Transaction.class));
            }
        });

        loan_checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Banking.this,Loan_checker.class));
            }
        });

        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Banking.this,About_us.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Banking.this,Login_page.class));
            }
        });
    }
}