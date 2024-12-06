package com.example.ddm_nativo_20242.comunicacao.bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class GerenciadorBT {

    //parte bluetooth
    BluetoothDevice bd;
    BluetoothAdapter ba;
    BluetoothSocket bs;
    //    String enderecoBluetooth = "";//MAC do bluetooth
    UUID uuid;

    //parte comum
    InputStream is;
    OutputStream os;
    Context c;

    public GerenciadorBT(Context c, BluetoothAdapter ba, String enderecoBluetooth) {

        this.ba = ba;
        this.c = c;

        bd = ba.getRemoteDevice(enderecoBluetooth);
        try {
            if (ActivityCompat.checkSelfPermission(c, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                Log.e("BT", "SEM PERMISSAO...");
                return;
            }
            bs = bd.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
            bs.connect();
            os = bs.getOutputStream();
            is = bs.getInputStream();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void enviar(String s){
        Toast.makeText(c, "ENVIANDO DADOS",Toast.LENGTH_SHORT).show();

        try {
            os.write(s.getBytes());
            //os.write(Integer.parseInt(s));
            os.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public String receber(){

        Toast.makeText(c, "RECEBENDO",Toast.LENGTH_SHORT).show();

        byte[] buffer = new byte[1024];

        try{
            is.read(buffer, 0, buffer.length);
        }catch(IOException e){
            e.printStackTrace();
        }

        return new String(buffer);
    }

    public void fechar(){
        try {
            is.close();
            os.close();
            bs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}