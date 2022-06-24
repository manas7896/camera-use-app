package com.example.login_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();

        String username = intent.getStringExtra("user123");
     //   user_name.setText(username);
       // Toast.makeText(Activity2.this, username, Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.usertxt);
        textView.setText(username);

    }
}