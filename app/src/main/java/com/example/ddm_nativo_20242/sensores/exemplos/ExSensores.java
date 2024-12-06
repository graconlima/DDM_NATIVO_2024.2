package com.example.ddm_nativo_20242.sensores.exemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.example.ddm_nativo_20242.R;

import java.util.List;

public class ExSensores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_sensores);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        //teste de sensores

        //Ambiente
        Sensor s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_PRESSURE);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);//null

        //Movimento
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER_UNCALIBRATED);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_SIGNIFICANT_MOTION);//null

        //Posição
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED);

        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);//null
        //Sensor s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);//null

        sm.registerListener(new SensorEventListener(){
            @Override
            public void onSensorChanged(SensorEvent e) {

                for (float c: e.values) {
                    Log.i("SEN", "Dados do sensor: "+c);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor s, int precisao) {
                Log.i("SEN", s.toString());
            }
        }, s, sm.SENSOR_DELAY_NORMAL);
    }
}