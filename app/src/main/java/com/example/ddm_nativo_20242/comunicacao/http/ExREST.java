package com.example.ddm_nativo_20242.comunicacao.http;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.ddm_nativo_20242.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ExREST extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_rest);

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection huc;
                BufferedReader reader;
                String s = "";
                String linha = "";
                StringBuffer buffer = new StringBuffer();
                try{
                    URL u = new URL("https://jsonplaceholder.typicode.com/todos");
                    huc = (HttpURLConnection) u.openConnection();
                    huc.setRequestMethod("GET");
                    huc.setConnectTimeout(10000);
                    huc.setReadTimeout(15000);
                    huc.connect();
                    InputStream inputStream;
                    if(huc.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST){
                        inputStream = huc.getInputStream();
                        System.out.println("Ok");

                    }else{
                        inputStream = huc.getErrorStream();
                        System.out.println("Err");

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
            }
        }).start();
    }
}