package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


        AlertDialog.Builder user_error = new AlertDialog.Builder(this);
        user_error.setTitle("Sign-in Failed");
        user_error.setMessage("Username should be 6 characters long,can contain only letters,numbers,dash and underscore");
        user_error.setIcon(R.drawable.empty_error);
        user_error.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        AlertDialog alert_2 = user_error.create();


        AlertDialog.Builder pass_match = new AlertDialog.Builder(this);
        pass_match.setTitle("Sign-in Failed");
        pass_match.setMessage("PASSWORD DOESN'T MATCH.");
        pass_match.setIcon(R.drawable.empty_error);
        pass_match.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ;
            }
        });
        AlertDialog alert_3 = pass_match.create();


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
                    empty.show();
                }
                else {
                    if(!isvalid(signup_username))
                    {
                        alert_2.show();
                    }
                    else {
                        if (signup_confirm_password.equals(signup_password)) {
                            Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Signup.this, Login_page.class));
                        } else {
                            alert_3.show();


                        }
                    }
                }
            }
        });



    }

    public static boolean isvalid(String u)
    {
        int flag=1;
        if(u.length()<6)
        {
            return false;
        }
        for(int i=0;i<u.length();i++)
        {
            if(Character.isAlphabetic(u.charAt(i)) || Character.isDigit(u.charAt(i)) || (u.charAt(i)=='-')|| (u.charAt(i)=='_') || (u.charAt(i)=='@'))
            {
            }
            else {
                flag=0;
            }
        }
        return flag!=0;

    }
}