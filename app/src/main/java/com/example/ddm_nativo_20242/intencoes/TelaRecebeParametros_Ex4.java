package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ddm_nativo_20242.R;

public class TelaRecebeParametros_Ex4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_recebe_parametros_ex4);

        //exemplo 1
        /*Intent i = getIntent();
        String s = i.getStringExtra("dado");
        Log.i("Informacao", s);*/

        //exemplo 2
        Intent i = getIntent();
        Bundle b = i.getExtras();

        Log.i("Informacao", b.getString("string1"));
        Log.i("Informacao", b.getString("dado"));
        Log.i("Informacao", String.valueOf(b.getFloat("valor")));
    }
}