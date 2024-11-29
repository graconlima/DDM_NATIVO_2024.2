package com.example.ddm_nativo_20242.threads;

public class ThreadExemplo extends Thread{

    int a = 10;
    int TEMPO = 1000;

    @Override
    public void run() {
        super.run();
        while(true){

            try {
                Thread.sleep(TEMPO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a++;
        }
    }
}
