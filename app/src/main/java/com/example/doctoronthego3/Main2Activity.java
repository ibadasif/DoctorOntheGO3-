package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Main2Activity extends AppCompatActivity {
    ViewFlipper v_flipper;
    ImageView diagnose;
    ImageView pedometer;
    ImageView map;
    ImageView amb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int images[]={R.drawable.ins,R.drawable.wdoc,R.drawable.bdoc,R.drawable.docs20};
        setContentView(R.layout.activity_main2);
        v_flipper= findViewById(R.id.v_flipper);
        for (int i = 0; i < images.length; i++){
            flipperImages(images[i]);
        }
        for (int image: images){
            flipperImages(image);
        }

        diagnose= findViewById(R.id.dig);
        diagnose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Main2Activity.this,Diagnose.class);
                startActivity(a);
            }
        });
        pedometer= findViewById(R.id.pedo);
        pedometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b =new Intent(Main2Activity.this,Pedometer.class);
                startActivity(b);
            }
        });
        map= findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(Main2Activity.this, Maps.class);
                startActivity(c);
            }
        });
        amb =findViewById(R.id.emergency);
        amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(Main2Activity.this, Emergency.class);
                startActivity(d);
            }
        });

    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);


    }
}
