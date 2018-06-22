package com.example.admin.luckycup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.luckycup.Beans.Usuario;
import com.example.admin.luckycup.DAO.DAOUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final Usuario usuario = new Usuario();
        usuario.setLogin( "aa" );
        usuario.setSenha( "1" );

        DAOUsuario inserir = new DAOUsuario( getBaseContext());
        inserir.open();
        inserir.insert( usuario );
        inserir.close();

        Button btnLogin = (Button) findViewById( R.id.btnLogin );
        btnLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tLogin = (TextView) findViewById( R.id.tLogin );
                TextView tSenha = (TextView) findViewById( R.id.tSenha );

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                DAOUsuario s = new DAOUsuario(getBaseContext());

                s.open();


                if(login.equals(s.RetornaUsuario().getLogin() ) && senha.equals(s.RetornaUsuario().getSenha())) {

                    alert( "Login realizado com sucesso" );

                    Intent Dashboard = new Intent(MainActivity.this, com.example.admin.luckycup.Dashboard.class);

                    MainActivity.super.finish();

                    startActivity( Dashboard );

                    s.delete();

                }else{

                    alert( "Verifique os campos" );

                }
            }
        } );
    }
    private void alert(String s){
        Toast.makeText( this, s, Toast.LENGTH_SHORT ).show();
    }
}
