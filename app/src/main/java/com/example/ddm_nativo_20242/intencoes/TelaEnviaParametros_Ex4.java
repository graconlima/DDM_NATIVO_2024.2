package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ddm_nativo_20242.R;

public class TelaEnviaParametros_Ex4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_envia_parametros_ex4);

        Button b = (Button) findViewById(R.id.botao);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent("com.example.graco.exintent.Tela");

                //exemplo1
                //i.putExtra("dado","dado");

                //exemplo 2
                Bundle b = new Bundle();
                b.putString("string1", "dados da string 1");
                b.putString("dado", "variavel de dados");
                b.putFloat("valor", 1.7f);

                i.putExtras(b);//cuidado com o s
                startActivity(i);

            }
        });
    }
}
