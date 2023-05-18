package com.example.project;


import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {

    Button id_login;
    Button id_signup;
    EditText id_username;
    EditText id_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        id_login = findViewById(R.id.loginbutton);
        id_username = findViewById(R.id.username);
        id_password = findViewById(R.id.password);
        id_signup = findViewById(R.id.signup_ask_button);

        AlertDialog.Builder empty = new AlertDialog.Builder(this);
        empty.setTitle("Sign-in Failed");
        empty.setMessage("Fill all details.");
        empty.setIcon(R.drawable.empty_error);
        empty.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        AlertDialog alert = empty.create();

        id_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = id_username.getText().toString();
                String password = id_password.getText().toString();
                if (username.length() == 0 || password.length() == 0) {
                    alert.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login_page.this, Banking.class));
                }
            }
        });

        id_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_page.this, Signup.class));
            }

        });



    }

}
