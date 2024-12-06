package com.example.ddm_nativo_20242.persistencia.banco_dados;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
class AbrirBD extends SQLiteOpenHelper{
    private static final String NOME_BD = "aluno";
    private static final int VERSAO_BD = 1;
    public AbrirBD(Context c){
        super(c,NOME_BD, null, VERSAO_BD);
    }
    public void onCreate(SQLiteDatabase bd){
        bd.execSQL("create table aluno(" +
                "_id integer primary key autoincrement, " +
                "matricula text not null, " +
                "nome text not null)");
    }
    public void onUpgrade(SQLiteDatabase bd, int vi, int vf){
        bd.execSQL("drop table aluno");
        onCreate(bd);
    }
}
