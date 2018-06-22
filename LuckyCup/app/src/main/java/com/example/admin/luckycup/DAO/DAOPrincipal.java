package com.example.admin.luckycup.DAO;

/**
 * Created by Admin on 17/06/2018.
 */

import java.util.ArrayList;
import java.util.List;
import com.example.admin.luckycup.Beans.Principal;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOPrincipal {

    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String ID_PALPITE = "id_Palpite";
    public static final String ID_PARTIDA = "id_Partida";
    public static final String NOME = "Nome";
    public static final String GSA = "gsA";
    public static final String GSB = "gsB";

    public static final String[] todasAsColunas =
            {
                    ID_PALPITE, ID_PARTIDA, NOME, GSA, GSB
            };

    // Tabela
    public static final String TABELA_PRINCIPAL = "Principal";

    public DAOPrincipal(Context contexto) {
        gerenciaBanco = new GerenciaBanco( contexto );
    }

    public void open() throws SQLException {
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close() {
        gerenciaBanco.close();
    }

    public void insert(Principal item) {
        ContentValues valores = new ContentValues();
        valores.put( ID_PARTIDA, item.getId_Partida() );
        valores.put( NOME, item.getNome() );
        valores.put( GSA, item.getGsA() );
        valores.put( GSB, item.getGsB() );

        banco.insert( TABELA_PRINCIPAL, null, valores );
    }

    public void update(Principal item) {
        ContentValues valores = new ContentValues();

        valores.put( ID_PALPITE, item.getId_Palpite() );
        valores.put( ID_PARTIDA, item.getId_Partida() );
        valores.put( NOME, item.getNome() );
        valores.put( GSA, item.getGsA() );
        valores.put( GSA, item.getGsB() );

        banco.update( TABELA_PRINCIPAL, valores, ID_PALPITE + " = " + item.getId_Palpite(), null );
    }

    public void delete(Principal item) {
        int id = item.getId_Palpite();
        banco.delete( TABELA_PRINCIPAL, ID_PALPITE + " = " + id, null );
    }

    public List<Principal> selectTodos() {
        List<Principal> itens = new ArrayList<Principal>();
        Cursor cursor = banco.query( TABELA_PRINCIPAL, // tabela
                todasAsColunas, // colunas
                null,           // where
                null,           // where hacks
                null,           // group by
                null,           // having
                ID_PARTIDA );      // order by
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Principal item = cursorToItem( cursor );
            itens.add( item );
            cursor.moveToNext();
        }
        cursor.close();
        return itens;
    }

    private Principal cursorToItem(Cursor cursor) {
        Principal item = new Principal();

        item.setId_Palpite( cursor.getInt( 0 ) );
        item.setId_Partida( cursor.getInt( 1 ) );
        item.setNome( cursor.getString( 2 ) );
        item.setGsA( cursor.getInt( 3 ) );
        item.setGsB( cursor.getInt( 4 ));

        return item;
    }
}
