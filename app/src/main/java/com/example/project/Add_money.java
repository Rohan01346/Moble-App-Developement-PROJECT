package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_money extends AppCompatActivity {

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

        id_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String send_account_number = id_send_account_number.getText().toString();
                String send_password = id_send_password.getText().toString();
                String send_amount = id_send_amount.getText().toString();
                if(send_amount.length()==0 || send_password.length()==0 || send_account_number.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Transfered"+" "+send_amount, Toast.LENGTH_SHORT).show();
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