package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    Button id_register;
    EditText id_signup_name;
    EditText id_signup_password;
    EditText id_signup_confirm_password;
    EditText id_signup_username;
    EditText id_signup_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        id_register= findViewById(R.id.register);
        id_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id_signup_confirm_password=findViewById(R.id.confirmpassword);
                id_signup_email=findViewById(R.id.email);
                id_signup_name=findViewById(R.id.name);
                startActivity(new Intent(Signup.this,Login_page.class));
            }
        });



    }
}