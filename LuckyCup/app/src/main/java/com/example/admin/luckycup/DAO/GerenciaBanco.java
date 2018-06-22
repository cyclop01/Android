package com.example.admin.luckycup.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by Admin on 16/06/2018.
 */

public class GerenciaBanco extends SQLiteOpenHelper {

    // dados do banco
    private static final String NOME_BANCO = "sysdb";
    private static final int VERSAO_BANCO = 1;

    // tabelas
    private static final String Selecao =
            "CREATE TABLE Selecao ( " +
                    "id_Selecao  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Descricao  TEXT " +
                    ");";
    private static final String Partida =
            "CREATE TABLE Partida ( " +
                    "id_Partida  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "idsA  INTEGER, " +
                    "idsB  INTEGER, " +
                    "data  INTEGER, " +
                    "hora  INTEGER " +
                    ");";
    private static final String Principal =
            "CREATE TABLE Principal ( " +
                    "id_Palpite  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "id_Partida  INTEGER, " +
                    "Nome    TEXT, " +
                    "gsA    INTEGER, " +
                    "gsB    INTEGER " +
                    ");";

    private static final String Usuario =
            "CREATE TABLE Usuario ( " +
                    "Login TEXT, " +
                    "Senha    TEXT " +
                    ");";


    public GerenciaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // criação do banco
        db.execSQL(Selecao);
        db.execSQL(Partida);
        db.execSQL(Principal);
        db.execSQL(Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Setup inicial do banco. Ignorando upgrade
    }



}
