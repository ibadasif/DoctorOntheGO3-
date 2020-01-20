package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    DatabaseHelper MyDBhelper;
    EditText editEmail, editUsername, editPassword, editPhone;
    Button sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        MyDBhelper = new DatabaseHelper(this);

        editEmail = findViewById(R.id.email);
        editUsername = findViewById(R.id.user);
        editPassword = findViewById(R.id.pass);
        editPhone = findViewById(R.id.phone);
        sm= findViewById(R.id.SP);

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDBhelper.insertData(editEmail.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(), editPhone.getText().toString());
                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent a =new Intent(Signup.this,Main2Activity.class);
                startActivity(a);
            }
        });


    }
}
