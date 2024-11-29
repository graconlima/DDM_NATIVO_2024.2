package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.ddm_nativo_20242.R;

public class ExIntent_Ex1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_intent);

        //exemplos de intenções
        //abrir navegador
        /*-Uri u = Uri.parse("https://www.ifrn.edu.br");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);*/

        //realizar uma ligação
        /*Uri u = Uri.parse("tel:999999999");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);*/

        //exibir os contatos
        /*Uri u = Uri.parse("content://com.android.contacts/contacts");
        Intent i = new Intent(Intent.ACTION_VIEW, u);
        startActivity(i);*/

        Intent i = new Intent("ABRIR_TELA2");
        startActivity(i);
    }
}