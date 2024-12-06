package com.example.ddm_nativo_20242.threads.exemplo_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.ddm_nativo_20242.R;
import com.example.ddm_nativo_20242.threads.exemplo_01.ExThreadInicial;

public class ExemploHandler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo_handler);

        //exemplo 1
        final Handler h = new Handler(getMainLooper());
        new Thread(){
            public void run(){
                h.post(new Runnable() {
                    public void run() {
                        //executando da forma certa: com Handler
                        Toast.makeText(ExemploHandler.this, "Mensagem Toast", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }.start();

        //exemplo 2
        /*new Thread(){
            public void run() {
                runOnUiThread(
                        new Runnable() {
                            public void run() {
                                Toast.makeText(ExemploHandler.this, "Mensagem Toast", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
            }
        }.start();*/

    }
}