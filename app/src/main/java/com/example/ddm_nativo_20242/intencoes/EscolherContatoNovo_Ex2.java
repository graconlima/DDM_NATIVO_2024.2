package com.example.ddm_nativo_20242.intencoes;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ddm_nativo_20242.R;

public class EscolherContatoNovo_Ex2 extends AppCompatActivity {

    TextView tv;

    ActivityResultLauncher<Intent> arl = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //codigo
                    Intent i = result.getData();
                    tv = findViewById(R.id.tv);
                    tv.setText("mensagem:"+i.toString());
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_contato_novo_ex2);

        Button b = findViewById(R.id.botao);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri u = Uri.parse("content://com.android.contacts/contacts");
                Intent i = new Intent(Intent.ACTION_PICK, u);
                arl.launch(i);
            }
        });
    }
}