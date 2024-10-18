package com.example.ddm_nativo_20242.introducao;

import android.os.Bundle;
import android.app.Activity;
public class CicloDeVidaAtividade extends Activity {

    protected void onCreate(Bundle estado) {
        super.onCreate(estado);
        System.out.println(" onCreate() ");
    }
    protected void onStart(){
        super.onStart();
        System.out.println(" onStart() ");
    }
    protected void onResume(){
        super.onResume();
        System.out.println(" onResume() ");
    }
    protected void onPause(){
        super.onPause();
        System.out.println(" onPause() ");
    }
    protected void onStop(){
        super.onStop();
        System.out.println(" onStop() ");
    }
    protected void onDestroy(){
        super.onDestroy();
        System.out.println(" onDestroy() ");
    }
    protected void onRestart(){
        super.onRestart();
        System.out.println(" onRestart() ");
    }
}

