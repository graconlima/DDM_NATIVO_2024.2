package com.example.ddm_nativo_20242.persistencia.arquivos;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GerenciadorArquivo {
    OutputStream fos = null;
    Context c;

    GerenciadorArquivo(Context c){
        this.c = c;
    }

    public void criarArquivo(){
        String path = c.getExternalCacheDir().getAbsolutePath();

        File aux = new File(path, "pic.txt");
        if(aux.exists()){
            Log.i("ARQ", "DELETANDO ARQUIVO... ");
            aux.delete();
        }

        File arq = new File(path, "pic.txt");
        Log.i("ARQ","CRIANDO ARQUIVO... ");

        try {
            fos = new FileOutputStream(arq);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void gravarNoArquivo(int i){
        try {
            fos.write(i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("PRONTO!!");
    }

    public void fecharArquivo(){
        try {
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
