package com.example.ddm_nativo_20242.comunicacao.http.atualizar_ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ddm_nativo_20242.R;

public class TelaInicial extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Intent i = getIntent();
        String s = i.getStringExtra("nome");

        //exibir a saudacao
        TextView tv = findViewById(R.id.tv);
        tv.setText("Ola "+((s == null)? "Aluno": s)+", bom dia!");

        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("Baixar Dados HUC");
                startActivity(i);
            }
        });
    }
}