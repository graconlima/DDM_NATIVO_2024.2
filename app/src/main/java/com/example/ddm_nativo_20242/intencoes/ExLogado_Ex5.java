package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ddm_nativo_20242.R;

public class ExLogado_Ex5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_logado_ex5);

        Intent i = getIntent();
        String s = i.getStringExtra("nome");
        //exibir a saudacao
        TextView tv = findViewById(R.id.tv);
        tv.setText("Ola "+s+", bom dia!");
    }
}