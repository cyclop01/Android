package com.example.admin.passagemintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //Referenciando os objetos da tela para futura manipulacao
        //txts
        final EditText nome = (EditText) findViewById( R.id.txtNome );
        final EditText sobrenome = (EditText) findViewById( R.id.txtSobrenome );
        final EditText telefone = (EditText) findViewById( R.id.txtTelefone );

        //btns
        Button ok = (Button) findViewById( R.id.btnOk );

        ok.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                //Chamada para nova Activity
                Intent it = new Intent( MainActivity.this, Aviso.class );
                it.putExtra( "Nome", nome.getText().toString() );
                it.putExtra( "Sobrenome", sobrenome.getText().toString() );
                it.putExtra( "Telefone", telefone.getText().toString() );
                startActivity( it );
            }
        } );

    }
}
