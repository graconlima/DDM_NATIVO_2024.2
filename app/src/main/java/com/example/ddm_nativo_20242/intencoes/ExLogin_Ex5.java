package com.example.ddm_nativo_20242.intencoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ddm_nativo_20242.R;

public class ExLogin_Ex5 extends Activity {
    @Override
    protected void onCreate(Bundle estado) {
        super.onCreate(estado);

        //Ex salvar estado de objtos: para o caso de rotacionar, a lista de objetos precisa ser salva
        //estado.putSerializable("minha_lista", lista_encadeada_serializada);

        setContentView(R.layout.activity_ex_login_ex5);
        EditText campoNome = findViewById(R.id.campoNome);
        EditText campoSenha = findViewById(R.id.campoSenha);
        Button b = findViewById(R.id.botaoEnviar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacao(campoNome.getText().toString(), campoSenha.getText().toString());
            }
        });
    }

    public void autenticacao(String nome, String senha){
        if(nome.equals("Aluno") && senha.equals("123")){
            Toast.makeText(this, "Autenticado", Toast.LENGTH_LONG).show();
            Intent i = new Intent("Chamar Tela Saudacao");
            i.putExtra("nome", nome);
            startActivity(i);
        }else{
            Toast.makeText(this, "Não Autenticado", Toast.LENGTH_LONG).show();
        }
    }
}