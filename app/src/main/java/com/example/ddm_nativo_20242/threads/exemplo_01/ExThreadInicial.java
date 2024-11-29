package com.example.ddm_nativo_20242.threads.exemplo_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ddm_nativo_20242.R;

public class ExThreadInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_thread_inicial);

        new Thread(){
            public void run(){
                //forcando erro de Runtime
                Toast.makeText(ExThreadInicial.this, "Mensagem Toast", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }
}