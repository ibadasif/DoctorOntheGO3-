package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    DatabaseHelper MyDBhelper;
    EditText editemail, editpassword;
    Cursor cursor;
    Button login;
    TextView signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();

        editemail = findViewById(R.id.userlogin);
        editpassword = findViewById(R.id.passlogin);
        login= findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editemail.getText().toString();
                String password = editpassword.getText().toString();
                cursor = db.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME+" WHERE " + DatabaseHelper.COL_2 +" =? AND "+ DatabaseHelper.COL_4+" =? ", new String[]{email,password});
                if (cursor!=null){
                    if (cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_SHORT).show();
                        Intent go = new Intent(LoginPage.this, Main2Activity.class);
                        startActivity(go);
                    }

                    else { Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        signup= findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(LoginPage.this, Signup.class);
                startActivity(b);
            }
        });
    }
}
