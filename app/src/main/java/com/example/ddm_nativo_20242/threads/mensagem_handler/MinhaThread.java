package com.example.ddm_nativo_20242.threads.mensagem_handler;
import android.os.Handler;
import android.os.Message;

public class MinhaThread extends Thread{
    private Handler h;
    public MinhaThread(Handler h){
        this.h = h;
    }
    public void run(){
        for(int i = 0; i<10;i++){
            Message m = new Message();
            m.what = 1;
            m.obj = "Numero "+i;

            h.sendMessage(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		Message m = new Message();
		m.what = 3;
		h.sendMessage(m);

    }
}

