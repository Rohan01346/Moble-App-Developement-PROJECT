package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                if (loan_account_number.length() == 0 || amount_want.length() == 0 || loan_name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "You are Eligibile!!", Toast.LENGTH_SHORT).show();
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