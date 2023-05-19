package com.example.project;

import static com.example.project.Signup.isvalid;

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

public class Loan_checker extends AppCompatActivity {
    Button id_check;
    EditText id_loan_name;
    EditText id_loan_account_number;
    EditText id_amount_want;
    Button id_back_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_checker);

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


        id_check=findViewById(R.id.check);
        id_loan_account_number=findViewById(R.id.loan_account_number);
        id_loan_name=findViewById(R.id.loan_name);
        id_amount_want=findViewById(R.id.amount_want);
        id_back_2=findViewById(R.id.back_2);
        id_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loan_account_number = id_loan_account_number.getText().toString();
                String amount_want = id_amount_want.getText().toString();
                String loan_name = id_loan_name.getText().toString();
                Database db = new Database(getApplicationContext(),"BANKING",null,1);
                if (loan_account_number.length() == 0 || amount_want.length() == 0 || loan_name.length() == 0) {
                    alert.show();
                }

                else{
                    SharedPreferences sharedPreferences = getSharedPreferences("shared", Context.MODE_PRIVATE);
                    String loan_username = sharedPreferences.getString("username","").toString();
                    int signup_balance = sharedPreferences.getInt("balance",0);

                    if(db.name_account_no_check(loan_username,loan_name,loan_account_number)==1) {

                        if ((db.account_no_check(loan_account_number)) == 1) {
                            int check_amount = Integer.parseInt(amount_want);
                            if (check_amount <= 2 * signup_balance) {
                                Toast.makeText(getApplicationContext(), "You are Eligibile!!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "You are not Eligibile!!", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                    else{
                        alert_1.show();
                    }

                }
            }
        });
        id_back_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loan_checker.this,Banking.class));
            }
        });
    }
}