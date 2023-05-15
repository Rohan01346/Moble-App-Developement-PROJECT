package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                id_signup_password=findViewById(R.id.password);
                id_signup_username=findViewById(R.id.username);

                String signup_confirm_password = id_signup_confirm_password.getText().toString();
                String signup_email = id_signup_email.getText().toString();
                String signup_name = id_signup_name.getText().toString();
                String signup_password=id_signup_password.getText().toString();
                String signup_username=id_signup_username.getText().toString();

                if (signup_confirm_password.length() == 0 || signup_email.length() == 0 || signup_name.length() == 0 ||signup_password.length() == 0 || signup_username.length() == 0) {
                    Toast.makeText(getApplicationContext(), "fill the details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (signup_confirm_password.equals(signup_password)) {
                        Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Signup.this,Login_page.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "password doesn't match", Toast.LENGTH_SHORT).show();


                    }
                }

            }
        });



    }
}