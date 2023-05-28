package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_money extends AppCompatActivity {

    EditText id_add_account_number;
    EditText id_add_password;
    EditText id_add_amount;
    Button id_add_money;
    Button id_back_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);
        id_add_account_number = findViewById(R.id.add_to_account_number);
        id_add_password = findViewById(R.id.add_pass);
        id_add_amount = findViewById(R.id.amount_add);
        id_add_money=findViewById(R.id.add_money);
        id_back_4 = findViewById(R.id.back_4);

        AlertDialog.Builder user_not_exist = new AlertDialog.Builder(this);
        user_not_exist.setTitle("Invalid Input");
        user_not_exist.setMessage("Invalid Account No. And Name");
        user_not_exist.setIcon(R.drawable.empty_error);
        user_not_exist.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert_1 = user_not_exist.create();



        AlertDialog.Builder empty = new AlertDialog.Builder(this);
        empty.setTitle("Sign-in Failed");
        empty.setMessage("Fill all details .");
        empty.setIcon(R.drawable.empty_error);
        empty.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        AlertDialog alert = empty.create();

        AlertDialog.Builder added = new AlertDialog.Builder(this);
        added.setTitle("Congratulations");
        added.setMessage("Money Added Successfully.");
        added.setIcon(R.drawable.empty_error);
        added.setPositiveButton("Check Account Details", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Add_money.this, Account_details.class));
            }
        });
        AlertDialog alert_3 = added.create();



        id_add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext(),"BANKING",null,1);

                SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
                String account_no= sharedPreferences.getString("account_no","").toString();
                String password = sharedPreferences.getString("password","").toString();
                String username = sharedPreferences.getString("username","").toString();
                int balance = sharedPreferences.getInt("balance",0);

                String add_account_number = id_add_account_number.getText().toString();
                String add_password = id_add_password.getText().toString();
                String amount = id_add_amount.getText().toString();

                if(amount.length()!=0 || add_password.length()!=0 || add_account_number.length()!=0)
                {
                    int add_amount=Integer.parseInt(amount);
                    if(add_account_number.equals(account_no) && add_password.equals(password))
                    {
                        db.update_add_amount(add_amount,username);
                        alert_3.show();
                        sharedPreferences.edit().putInt("balance",balance+add_amount).apply();

                    }
                    else {
                        alert_1.show();
                    }


                }
                else {
                    alert.show();
                }
            }
        });

        id_back_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Add_money.this,Banking.class));
            }
        });

    }
}