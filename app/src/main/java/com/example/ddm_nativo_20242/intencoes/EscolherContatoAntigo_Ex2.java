package com.example.ddm_nativo_20242.intencoes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.example.ddm_nativo_20242.R;

public class EscolherContatoAntigo_Ex2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_contato2);

        //escolher contatos - antigo
        Uri u = Uri.parse("content://com.android.contacts/contacts");
        Intent i = new Intent(Intent.ACTION_PICK, u);
        startActivityForResult(i,1);
    }

    //escolher contatos - antigo
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {

            Toast.makeText(this, "Nenhum contato", Toast.LENGTH_SHORT).show();
        } else {
            //URI para visualizar o resultado
            Uri u = data.getData();
            Toast.makeText(this, "Contato: " + u, Toast.LENGTH_SHORT).show();
        }
    }

}