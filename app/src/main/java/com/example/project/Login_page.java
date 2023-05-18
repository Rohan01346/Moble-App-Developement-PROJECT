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
        user_not_exist.setTitle("Sign-in Failed");
        user_not_exist.setMessage("Invalid Username Or Password . ");
        user_not_exist.setIcon(R.drawable.empty_error);
        user_not_exist.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        AlertDialog alert_2 = user_not_exist.create();




        id_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = id_username.getText().toString();
                String password = id_password.getText().toString();
                Database db = new Database(getApplicationContext(),"BANKING",null,1);
                if (username.length() == 0 || password.length() == 0) {
                    alert.show();
                } else {
                    if(db.login(username,password)==1)
                    {
                        SharedPreferences sharedPreferences;
                        sharedPreferences = getSharedPreferences("shared",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("login_username",username);
                        editor.apply();
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login_page.this, Banking.class));
                    }
                    else {
                        alert_2.show();
                    }

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
