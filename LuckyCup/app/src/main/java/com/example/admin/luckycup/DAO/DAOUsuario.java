package com.example.admin.luckycup.DAO;

/**
 * Created by Admin on 17/06/2018.
 */
import java.util.ArrayList;
import java.util.List;
import com.example.admin.luckycup.Beans.Usuario;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAOUsuario {

    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String LOGIN = "Login";
    public static final String SENHA = "Senha";

    public static final String[] todasAsColunas =
            {
                    LOGIN, SENHA
            };

    // Tabela
    public static final String TABELA_USUARIO = "Usuario";

    public DAOUsuario(Context contexto) {
        gerenciaBanco = new GerenciaBanco( contexto );
    }

    public void open() throws SQLException {
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close() {
        gerenciaBanco.close();
    }

    public void insert(Usuario item) {
        ContentValues valores = new ContentValues();
        valores.put( LOGIN, item.getLogin() );
        valores.put( SENHA, item.getSenha() );

        banco.insert( TABELA_USUARIO, null, valores );
    }

    public void delete() {
        banco.delete( TABELA_USUARIO, null, null );
    }

    public Usuario RetornaUsuario() {
        Usuario usuario = new Usuario();
        Cursor cursor = banco.query( TABELA_USUARIO, // tabela
                todasAsColunas, // colunas
                null,           // where
                null,           // where hacks
                null,           // group by
                null,           // having
                null);      // order by
        cursor.moveToFirst();

        usuario = cursorToItem( cursor );

        cursor.close();

        return usuario;
    }

    private Usuario cursorToItem(Cursor cursor) {
        Usuario item = new Usuario();

        item.setLogin( cursor.getString( 0 ) );
        item.setSenha( cursor.getString( 1 ) );

        return item;
    }
}
