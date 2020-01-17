package com.example.doctoronthego3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Pedometer extends AppCompatActivity implements SensorEventListener {
    TextView tv;
    SensorManager SM;
    boolean runnning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometer);
        tv= findViewById(R.id.counter);
        SM =(SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        runnning = true;
        Sensor countersensor= SM.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countersensor != null){
            SM.registerListener(this, countersensor,SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, R.string.sensor_not_found, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        runnning=false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tv.setText(String.valueOf(event.values[0]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
