package com.example.admin.passagemintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Aviso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso);

        Intent it = getIntent();
        String nome = (String) getIntent().getSerializableExtra("Nome") ;
        String sobrenome = (String) getIntent().getSerializableExtra("Sobrenome") ;
        String fone = (String) getIntent().getSerializableExtra("Telefone") ;

        TextView resultado = (TextView) findViewById( R.id.txtMensagem );
        resultado.setText( "Ligando para " + "\n" + nome + " " + sobrenome + "\n" + fone );
        resultado.getText();
    }
}
