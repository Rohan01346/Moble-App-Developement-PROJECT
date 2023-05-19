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

public class Transaction extends AppCompatActivity {

    EditText id_send_account_number;
    EditText id_send_password;
    EditText id_send_amount;
    Button id_transfer;
    Button id_back_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        id_send_account_number = findViewById(R.id.send_to_account_number);
        id_send_password = findViewById(R.id.send_pass);
        id_send_amount = findViewById(R.id.amount_send);
        id_transfer=findViewById(R.id.transfer_button);
        id_back_1 = findViewById(R.id.back_1);


        AlertDialog.Builder user_not_exist = new AlertDialog.Builder(this);
        user_not_exist.setTitle("Invalid Input");
        user_not_exist.setMessage("Invalid Account Number . ");
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
        added.setMessage("Transaction Successfull.");
        added.setIcon(R.drawable.empty_error);
        added.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert_3 = added.create();




        AlertDialog.Builder passowrd = new AlertDialog.Builder(this);
        passowrd.setTitle("Invalid Input");
        passowrd.setMessage("Invalid Password .");
        passowrd.setIcon(R.drawable.empty_error);
        passowrd.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert_4 = passowrd.create();



        AlertDialog.Builder passowrd1 = new AlertDialog.Builder(this);
        passowrd1.setTitle("Transaction Failed");
        passowrd1.setMessage("Insufficient Balance .");
        passowrd1.setIcon(R.drawable.empty_error);
        passowrd1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog alert_5 = passowrd.create();


        id_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext(),"BANKING",null,1);

                SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
                String account_no= sharedPreferences.getString("account_no","").toString();
                String password = sharedPreferences.getString("password","").toString();
                String username = sharedPreferences.getString("username","").toString();
                int balance = sharedPreferences.getInt("balance",0);

                String send_account_number = id_send_account_number.getText().toString();
                String send_password = id_send_password.getText().toString();
                String amount = id_send_amount.getText().toString();

                if(amount.length()!=0 || send_password.length()!=0 || send_account_number.length()!=0)
                {
                    int send_amount = Integer.parseInt(amount);
                    if(db.account_no_check(send_account_number)==1)
                    {
                        if(password.equals(send_password))
                        {
                            if(balance >= send_amount)
                            {
                                db.update_transaction_amount(send_amount,username,send_account_number);
                                alert_3.show();
                                sharedPreferences.edit().putInt("balance",balance-send_amount).apply();
                            }
                            else {
                                alert_5.show();
                            }
                        }
                        else {
                            alert_4.show();
                        }
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

        id_back_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Transaction.this,Banking.class));
            }
        });

    }
}