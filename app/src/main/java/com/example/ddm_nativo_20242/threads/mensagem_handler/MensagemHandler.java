package com.example.ddm_nativo_20242.threads.mensagem_handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Message;
import android.os.Handler;

import com.example.ddm_nativo_20242.R;

public class MensagemHandler extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem_handler);
        tv = (TextView) findViewById(R.id.tv);

        Handler h = new Handler(getMainLooper()){
            public void handleMessage(Message m){
                atualizaUI(m);
            }
        };
        MinhaThread mt = new MinhaThread(h);
        mt.start();
    }
    public void atualizaUI(Message m){
        if(m.what == 1){
            tv.setText(m.obj.toString());
        }else if(m.what == 2){
            tv.setText("DOIS");
        }else{
            tv.setText("OUTRO");
        }
    }
}

