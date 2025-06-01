package com.example.brianapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnContinue = findViewById(R.id.btnContinue);
        EditText edtNama = findViewById(R.id.edtNama);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edtNama.getText().toString();
                Intent intent = new Intent(Login.this, Kalkulator.class);
                intent.putExtra("USER_NAME", userName);
                startActivity(intent);
                startActivity(intent);
            }

        });
    }
}