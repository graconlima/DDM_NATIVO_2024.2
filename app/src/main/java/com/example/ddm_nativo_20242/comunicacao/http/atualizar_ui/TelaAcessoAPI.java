package com.example.ddm_nativo_20242.comunicacao.http.atualizar_ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ddm_nativo_20242.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TelaAcessoAPI extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_acesso_api);

        new Thread(new Runnable() {
            TextView tv = findViewById(R.id.tv);
            StringBuffer buffer = new StringBuffer();
            @Override
            public void run() {

                //Trabalho pesado em segundo plano
                HttpURLConnection huc;
                BufferedReader reader;
                String s = "";
                String linha = "";
                try{
                    //URL u = new URL("http://192.168.1.105:8080/ApiRest/webresources/entidade.aluno");
                    URL u = new URL("https://jsonplaceholder.typicode.com/todos");
                    huc = (HttpURLConnection) u.openConnection();
                    huc.setRequestMethod("GET");
                    huc.setConnectTimeout(10000);
                    huc.setReadTimeout(15000);
                    huc.connect();
                    InputStream inputStream;
                    if(huc.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST){
                        inputStream = huc.getInputStream();
                    }else{
                        inputStream = huc.getErrorStream();
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    while((linha = reader.readLine()) != null) {
                        buffer.append(linha);
                        buffer.append("\n");
                    }
                    System.out.println("DADOS: "+buffer);
                }catch(Exception e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //atualização da interface gráfica
                        tv.setText(buffer);
                    }
                });
            }
        }).start();
    }
}