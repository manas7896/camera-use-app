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
        Button loginbt = (Button) findViewById(R.id.loginbutton);

        loginbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("Manas_123") && password.getText().toString().equals("manas1234567"))
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
                }
            }

        });
    }
}