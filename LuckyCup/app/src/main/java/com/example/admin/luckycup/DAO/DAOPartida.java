package com.example.admin.luckycup.DAO;

/**
 * Created by Admin on 16/06/2018.
 */
import java.util.ArrayList;
import java.util.List;
import com.example.admin.luckycup.Beans.Partida;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;


public class DAOPartida {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String ID_PARTIDA = "id_Partida";
    public static final String IDSA = "idsA";
    public static final String IDSB = "idsB";
    public static final String DATA = "data";
    public static final String HORA = "hora";

    public static final String[] todasAsColunas =
            {
                    ID_PARTIDA, IDSA, IDSB, DATA, HORA
            };

    // Tabela
    public static final String TABELA_PARTIDA = "Partida";

    public DAOPartida(Context contexto) {
        gerenciaBanco = new GerenciaBanco( contexto );
    }

    public void open() throws SQLException {
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close() {
        gerenciaBanco.close();
    }

    public void insert(Partida item) {
        ContentValues valores = new ContentValues();
        valores.put( IDSA, item.getIdsA() );
        valores.put( IDSB, item.getIdsB() );
        valores.put( DATA, item.getData() );
        valores.put( HORA, item.getHora() );

        banco.insert( TABELA_PARTIDA, null, valores );
    }

    public void update(Partida item) {
        ContentValues valores = new ContentValues();

        valores.put( ID_PARTIDA, item.getId_Partida() );
        valores.put( IDSA, item.getIdsA() );
        valores.put( IDSB, item.getIdsB() );
        valores.put( DATA, item.getData() );
        valores.put( HORA, item.getHora() );

        banco.update( TABELA_PARTIDA, valores, ID_PARTIDA + " = " + item.getId_Partida(), null );
    }

    public void delete(Partida item) {
        int id = item.getId_Partida();
        banco.delete( TABELA_PARTIDA, ID_PARTIDA + " = " + id, null );
    }

    public List<Partida> selectTodos() {
        List<Partida> itens = new ArrayList<Partida>();
        Cursor cursor = banco.query( TABELA_PARTIDA, // tabela
                todasAsColunas, // colunas
                null,           // where
                null,           // where hacks
                null,           // group by
                null,           // having
                ID_PARTIDA );      // order by
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Partida item = cursorToItem( cursor );
            itens.add( item );
            cursor.moveToNext();
        }
        cursor.close();
        return itens;
    }

    private Partida cursorToItem(Cursor cursor) {
        Partida item = new Partida();

        item.setId_Partida( cursor.getInt( 0 ) );
        item.setIdsA( cursor.getInt( 1 ) );
        item.setIdsB( cursor.getInt( 2 ) );
        item.setData( cursor.getInt( 3 ) );
        item.setHora( cursor.getInt( 4 ) );

        return item;
    }
}
