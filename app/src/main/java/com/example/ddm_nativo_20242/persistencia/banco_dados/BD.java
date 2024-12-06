package com.example.ddm_nativo_20242.persistencia.banco_dados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BD {
    private SQLiteDatabase bd;

    public BD(Context c){

        AbrirBD bdCore = new AbrirBD(c);
        bd = bdCore.getWritableDatabase();
    }

    public void inserir(Aluno a){

        ContentValues cv = new ContentValues();
        cv.put("matricula", a.getMatricula());
        cv.put("nome", a.getNome());

        bd.insert("aluno", null, cv);
    }

    public List<Aluno> buscar(){

        List<Aluno> l = new ArrayList<Aluno>();
        String[] colunas = new String[]{"_id","matricula","nome"};
        Cursor c = bd.query("aluno", colunas, null, null, null,null, "nome ASC");

        if(c.getCount() > 0){

            c.moveToFirst();
            do{

                Aluno a = new Aluno();
                a.setId(c.getInt(0));
                a.setMatricula(c.getString(1));
                a.setNome(c.getString(2));

                l.add(a);
            }while(c.moveToNext());

        }else{

            System.out.println("SEM DADOS");
        }
        return l;
    }

    public boolean buscar(Aluno a){
        String[] colunas = new String[]{"_id","matricula","nome"};
        Cursor c = bd.query("aluno", colunas, "matricula = \'"+a.getMatricula()+"\' and nome = \'"+a.getNome()+"\'", null, null,null, "nome ASC");

        if(c.getCount() > 0){
            System.out.println("Já Existe");
            return true;//existe
        }else{

            System.out.println("Não Existe");
            return false;
        }
    }

    public void deletar(Aluno a){

        bd.delete("aluno", "_id = "+a.getId(), null);
    }
}
