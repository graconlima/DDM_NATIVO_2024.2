package com.example.ddm_nativo_20242.interface_grafica;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ddm_nativo_20242.R;
import com.example.ddm_nativo_20242.componente_customizado.MeuEditText;

public class ExemploLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //layout com XML
        setContentView(R.layout.activity_exemplo_layout);

        EditText campoNome = findViewById(R.id.campoNome);
        EditText campoSenha = findViewById(R.id.campoSenha);
        Button b = findViewById(R.id.botaoEnviar);

        //Exemplo Eventos
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacao(campoNome.getText().toString(), campoSenha.getText().toString());
            }
        });

        //layout com API Java (simplificado)
        /*TextView textoNome = new TextView(this);
        textoNome.setText("Nome:");

        EditText campoNome = new EditText(this);

        TextView textoSenha = new TextView(this);
        textoSenha.setText("Senha: ");

        MeuEditText campoSenha = new MeuEditText(this, null);

        Button b = new Button(this);
        b.setText("ENVIAR!");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autenticacao(campoNome.getText().toString(), campoSenha.getText().toString());
            }
        });

        LinearLayout layoutPrincipal = new LinearLayout(this);
        layoutPrincipal.addView(textoNome);
        layoutPrincipal.addView(campoNome);
        layoutPrincipal.addView(textoSenha);
        layoutPrincipal.addView(campoSenha);
        layoutPrincipal.addView(b);
        setContentView(layoutPrincipal);*/

    }
    public void autenticacao(String nome, String senha){
        if(nome.equals("Aluno") && senha.equals("123")){
            Toast.makeText(this,"Autenticado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Não Autenticado", Toast.LENGTH_LONG).show();
        }
    }
}