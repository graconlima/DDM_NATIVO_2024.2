package com.example.ddm_nativo_20242.persistencia.banco_dados;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ddm_nativo_20242.R;

import java.util.List;
public class ExBD extends AppCompatActivity {

    String TAG = "ifo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_bd2);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Aluno a = new Aluno();
                a.setId(2);
                a.setNome("Carlos");
                a.setMatricula("333");

                BD bd = new BD(getBaseContext());

                if(bd.buscar(a)){
                    System.out.println("Aluno ja existe. nao adicionado");
                }else{
                    System.out.println("Adicionando aluno novo");
                    bd.inserir(a);
                }

                List<Aluno> l = bd.buscar();
                int i = 0;
                while(i < l.size()){
                    Log.i(TAG, "id: "+l.get(i).getId()+" Nome: " + l.get(i).getNome()+" Matricula: "+l.get(i).getMatricula());
                    i++;
                }
            }
        });
    }
}