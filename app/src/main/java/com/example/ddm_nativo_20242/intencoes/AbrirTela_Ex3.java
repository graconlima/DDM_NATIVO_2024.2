package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ddm_nativo_20242.R;

public class AbrirTela_Ex3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abrir_tela);

        Intent i = new Intent("ABRIR_TELA2");
        startActivity(i);
    }
}