package com.example.ddm_nativo_20242.comunicacao.bluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddm_nativo_20242.R;

public class ExBluetooth extends Activity {
    GerenciadorBT gerenciadorBT;
    String enderecoBluetooth = "20:13:05:09:17:72";
    BluetoothAdapter ba;
    TextView iv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_bluetooth);

        iv = findViewById(R.id.tv);

        //adquirindo e testando o adaptador bt
        ba = BluetoothAdapter.getDefaultAdapter();
        if (ba == null) {
            Toast.makeText(getBaseContext(), "NAO HA BLUETOOTH", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "TEM BT SIM!", Toast.LENGTH_SHORT).show();
        }

        //testando se o adaptador esta ativo
        if (ba.isEnabled()) {
            Toast.makeText(getBaseContext(), "BT ESTA ATIVO", Toast.LENGTH_SHORT).show();
        } else {
            //mandando ligar
            Toast.makeText(getBaseContext(), "LIGANDO BT", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                Log.e("BT", "Sem Permissao...");
                return;
            }
            startActivityForResult(i, 0);
        }

        gerenciadorBT = new GerenciadorBT(getBaseContext(),ba, enderecoBluetooth);

        Button b = findViewById(R.id.bt);
        EditText et = findViewById(R.id.et);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gerenciadorBT.enviar(et.getText().toString());
            }
        });
    }
}
