package com.example.ddm_nativo_20242.sensores.exemplos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.ddm_nativo_20242.R;

import java.util.LinkedList;
import java.util.List;

public class ListarSensoresDisponiveis extends AppCompatActivity {

    SensorManager sm;
    LinkedList<Sensor> s = new LinkedList<Sensor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_sensores_disponiveis);

        TextView tvls = findViewById(R.id.tvls);

        registerForContextMenu(tvls);
    }

    @Override
    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(m, v, menuInfo);

        //Exemplo 2: obtendo lista de sensores
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> ls = sm.getSensorList(Sensor.TYPE_ALL);

        ls.forEach((c) -> {
            s.add(sm.getDefaultSensor(c.getType()));
            m.add(c.getType(), s.size(), 0, c.getName());
            Log.i("SEN", c.getName());
            Log.i("SEN", "Tipo : "+c.getType());
        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem i) {
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
        }, s.get(i.getItemId()), sm.SENSOR_DELAY_NORMAL);

        return super.onContextItemSelected(i);
    }
}