package com.example.ddm_nativo_20242.comunicacao.soquete.tcp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ddm_nativo_20242.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Button b = findViewById(R.id.botao);
        TextView tv = findViewById(R.id.texto);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int porta = 1234;
                        String endereco = "10.25.2.170";
                        try {
                            Socket s = new Socket(endereco, porta);
                            byte[] b = new byte[1000];
                            InputStream is = s.getInputStream();
                            is.read(b);
                            String st = new String(b).trim();
                            System.out.println("Dados: "+ st);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv.setText(st);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
