package com.example.tretapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class loginActivity extends AppCompatActivity {
    private EditText emailEditText = findViewById(R.id.emailEditText);
    private EditText pwdEditText = findViewById(R.id.pwdEditText);
    private Button accedirButton = findViewById(R.id.accedirButton);
    private Button recuperarPwdButton = findViewById(R.id.recuperaPwdButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}