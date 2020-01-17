package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Maps extends AppCompatActivity {
    Button shos;
    Button sdoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        shos= findViewById(R.id.shos);
        shos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a =new Intent(Maps.this,HosMap.class);
                startActivity(a);
            }
        });
        sdoc= findViewById(R.id.sdoc);
        sdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b= new Intent(Maps.this, Doctors.class);
                startActivity(b);
            }
        });

    }
}
