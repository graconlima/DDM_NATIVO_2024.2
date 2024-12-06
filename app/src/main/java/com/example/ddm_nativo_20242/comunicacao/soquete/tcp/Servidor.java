package com.example.ddm_nativo_20242.comunicacao.soquete.tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;

public class Servidor {

    public Servidor(){

        try{
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("Aguardando novas conexões...");

            int i = 0;
            while(true){
                Socket s = ss.accept();
                OutputStream os = s.getOutputStream();
                String str = new String("Mensagem "+i+".");
                byte[] b = str.getBytes();
                os.write(b);
                os.close();
                System.out.println("Mensagem "+i+" enviada para: "+s.getInetAddress().getHostAddress());
                i++;
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void main(String args[]){
        new Servidor();
    }
}

