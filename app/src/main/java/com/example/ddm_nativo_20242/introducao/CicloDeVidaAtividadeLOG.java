package com.example.ddm_nativo_20242.introducao;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class CicloDeVidaAtividadeLOG extends Activity{

    private final String TAG = "informacao";

    protected void onCreate(Bundle estado) {
        super.onCreate(estado);
        Log.i(TAG, " onCreate() ");
    }
    protected void onStart(){
        super.onStart();
        Log.i(TAG," onStart() ");
    }
    protected void onResume(){
        super.onResume();
        Log.i(TAG," onResume() ");
    }
    protected void onPause(){
        super.onPause();
        Log.i(TAG," onPause() ");
    }
    protected void onStop(){
        super.onStop();
        Log.i(TAG," onStop() ");
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG," onDestroy() ");
    }
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG," onRestart() ");
    }
}
