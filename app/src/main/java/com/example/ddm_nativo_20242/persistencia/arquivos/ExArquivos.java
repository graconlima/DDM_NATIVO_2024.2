package com.example.ddm_nativo_20242.persistencia.arquivos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.ddm_nativo_20242.R;

import java.io.IOException;
import java.io.InputStream;

public class ExArquivos extends Activity {

    GerenciadorArquivo ga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_arquivos);

        ga = new GerenciadorArquivo(getBaseContext());
        ga.criarArquivo();
        ga.gravarNoArquivo(10);
        ga.fecharArquivo();
    }

    public byte[] receberImagem(InputStream is){

        System.out.println("Lendo imagem");
        byte[] buffer = new byte[5];

        try{

            int i = 0;
            int contador = 0;
            char[] eof = new char[3];
            int[] buf = new int[50000];
            String aux = "";

            ga.criarArquivo();

            while((i = is.read()) != -1){

                ga.gravarNoArquivo(i);
                buf[contador] = i;
                aux = aux.concat(""+ i);

                eof[0] = eof[1];
                eof[1] = eof[2];
                eof[2] = (char) i;
                System.out.println("lido: "+ (char) i +", EOF: "+new String(eof));

                if(new String(eof).equals("EOF")){
                    String[] s = aux.split("EOF");
                    System.out.println("s[0]:"+s[0]);
                    break;
                }

                contador++;
                System.out.println("Tamanho: "+contador);
            }

            ga.fecharArquivo();

            byte imagem[] = new byte[contador*4];
            int cont = 0;
            for(int x = 0; x < contador;x++) {

                int a = buf[x];

                imagem[cont + 3] = (byte) (a & 0xFF);
                imagem[cont + 2] = (byte) ((a & 0xFF) << 8);
                imagem[cont + 1] = (byte) ((a  & 0xFF) << 16);
                imagem[cont] = (byte) ((a  & 0xFF) << 24);

                cont += 4;
            }
            System.out.println("cont: "+cont+", tam: "+imagem.length);
            return imagem;
        }catch(IOException e){
            e.printStackTrace();
        }

        return new byte[0];
    }
}