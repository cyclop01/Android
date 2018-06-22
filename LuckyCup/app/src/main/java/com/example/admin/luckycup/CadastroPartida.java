package com.example.admin.luckycup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.admin.luckycup.Adapters.SelecaoSpinnerAdapter;
import com.example.admin.luckycup.Beans.Partida;
import com.example.admin.luckycup.Beans.Selecao;
import com.example.admin.luckycup.DAO.DAOPartida;

import java.util.List;

public class CadastroPartida extends AppCompatActivity implements View.OnClickListener {

    Spinner spnSelecaoA;
    Spinner spnSelecaoB;
    EditText edtGolsA;
    EditText edtGolsB;
    EditText edtNome;
    Button btnSalvar;

    List<Selecao> selecoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_cadastro_partida );


        spnSelecaoA = findViewById( R.id.spnSelecaoA );
        spnSelecaoB = findViewById( R.id.spnSelecaoB );

        edtGolsA = findViewById( R.id.txtGolsA );
        edtGolsB = findViewById( R.id.txtGolsB );
        edtNome = findViewById( R.id.txtNome );

        btnSalvar = findViewById( R.id.btnSalvar );

        btnSalvar.setOnClickListener( this );

        //selecoes = ...;

        SelecaoSpinnerAdapter adapter = new SelecaoSpinnerAdapter( this, selecoes );

        spnSelecaoA.setAdapter( adapter );

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSalvar:
                onSalvarClick();
                break;
        }
    }

    private void onSalvarClick(){

        Partida p = new Partida();

        p.setIdsA( selecoes.get( spnSelecaoA.getSelectedItemPosition() ).getId() );
        p.setIdsB( selecoes.get( spnSelecaoB.getSelectedItemPosition() ).getId() );
        //...

        DAOPartida dp = new DAOPartida( this );
        dp.open();

        dp.insert( p );

        dp.close();

    }
}
