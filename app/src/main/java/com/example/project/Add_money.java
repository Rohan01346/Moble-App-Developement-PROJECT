package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

        id_add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String add_account_number = id_add_account_number.getText().toString();
                String add_password = id_add_password.getText().toString();
                String add_amount = id_add_amount.getText().toString();
                if(add_amount.length()==0 || add_password.length()==0 || add_account_number.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "amount added successfully"+" "+id_add_money, Toast.LENGTH_SHORT).show();
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