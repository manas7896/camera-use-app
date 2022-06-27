package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView username = (TextView) findViewById(R.id.usernametxt);
        TextView password = (TextView) findViewById(R.id.passwordtxt);

        String pass = password.getText().toString();
        String user = username.getText().toString();
        Button loginbt = (Button) findViewById(R.id.loginbutton);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((username.getText().toString().length()==0) || (password.getText().toString().length()==0))
                {
                    if(password.getText().toString().length()==0)
                    Toast.makeText(MainActivity.this, "Password cannot be null", Toast.LENGTH_SHORT).show();

                    if(username.getText().toString().length()==0)
                        Toast.makeText(MainActivity.this, "Username cannot be null", Toast.LENGTH_SHORT).show();
                }
                else
                {if((username.getText().toString().equals("Manas") && password.getText().toString().equals("manas12345")) || (username.getText().toString().equals("test123") && password.getText().toString().equals("test12345")))
                {
                    Toast.makeText(MainActivity.this,"Login Successful !!",Toast.LENGTH_SHORT).show();
                    String user = username.getText().toString();
                    Intent intent =new Intent(getApplicationContext(),Activity2.class);
                   intent.putExtra("user123",user);
                    startActivity(intent);
                  //  setContentView(R.layout.activity_2);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Login UnSuccessful !!",Toast.LENGTH_SHORT).show();
                    if(password.getText().toString().length()<7)
                        Toast.makeText(MainActivity.this, "Password should be of 8 letters", Toast.LENGTH_SHORT).show();

                }
                }
            }

        });
    }
}