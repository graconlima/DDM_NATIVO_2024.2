package com.example.ddm_nativo_20242.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ddm_nativo_20242.R;

public class ExThread extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_thread);

        ThreadExemplo t1 = new ThreadExemplo();
        ThreadExemplo t2 = new ThreadExemplo();

        t1.TEMPO = 500;
        t1.start();

        t2.TEMPO = 1500;
        t2.start();

        while(true){
            System.out.print("T1: " + t1.a);
            System.out.println("T2: " + t2.a);
        }
    }
}