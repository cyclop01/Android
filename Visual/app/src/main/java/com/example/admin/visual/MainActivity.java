package com.example.admin.visual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int operacao = 0;
    public double valor1 = 0;
    public double valor2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );


        //Botoes de Acao
        Button limpar = (Button) findViewById( R.id.btnLimpar );
        Button processar = (Button) findViewById( R.id.btnProcessar );
        Button dividir = (Button) findViewById( R.id.btnDiv );
        Button b_somar = (Button) findViewById( R.id.btnSoma );
        Button multiplicar = (Button) findViewById( R.id.btnMult );
        Button b_subtrair = (Button) findViewById( R.id.btnMenos );
        //Numeros
        Button btn1 = (Button) findViewById( R.id.btn1);
        Button btn2 = (Button) findViewById( R.id.btn2);
        Button btn3 = (Button) findViewById( R.id.btn3);
        Button btn4 = (Button) findViewById( R.id.btn4);
        Button btn5 = (Button) findViewById( R.id.btn5);
        Button btn6 = (Button) findViewById( R.id.btn6);
        Button btn7 = (Button) findViewById( R.id.btn7);
        Button btn8 = (Button) findViewById( R.id.btn8);
        Button btn9 = (Button) findViewById( R.id.btn9);
        Button btn0 = (Button) findViewById( R.id.btn0);
        //TextView Resultado
        final TextView resultado = (TextView) findViewById( R.id.txtResultado );

        b_somar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                operacao = 1;
                valor1 =  Double.parseDouble(resultado.getText().toString());
                resultado.setText("");
            }
        } );

        b_subtrair.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                operacao = 2;
                valor1 =  Double.parseDouble(resultado.getText().toString());
                resultado.setText("");
            }
        } );

        multiplicar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                operacao = 3;
                valor1 =  Double.parseDouble(resultado.getText().toString());
                resultado.setText("");
            }
        } );

        dividir.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View d) {
                operacao = 4;
                valor1 =  Double.parseDouble(resultado.getText().toString());
                resultado.setText("");
            }
        } );

        processar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor2 = Double.parseDouble(resultado.getText().toString());
                switch (operacao){
                    case 1: resultado.setText(somar()); break;
                    case 2: resultado.setText(subtrair());break;
                    case 3: resultado.setText(multiplicar());break;
                    case 4: resultado.setText(dividir());break;
                }
            }
        } );

        limpar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  resultado.setText( null );
                    operacao = 0;
                    valor1 = 0;
                    valor2 = 0;
            }
        });

        btn1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "1" );
                }else{
                    resultado.setText(resultado.getText() + "1" );
                }
            }
        } );

        btn2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "2" );
                }else{
                    resultado.setText(resultado.getText() + "2" );
                }
            }
        } );

        btn3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "3" );
                }else{
                    resultado.setText(resultado.getText() + "3" );
                }
            }
        } );

        btn4.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "4" );
                }else{
                    resultado.setText(resultado.getText() + "4" );
                }
            }
        } );

        btn5.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "5" );
                }else{
                    resultado.setText(resultado.getText() + "5" );
                }
            }
        } );

        btn6.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "6" );
                }else{
                    resultado.setText(resultado.getText() + "6" );
                }
            }
        } );

        btn7.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "7" );
                }else{
                    resultado.setText(resultado.getText() + "7" );
                }
            }
        } );

        btn8.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "8" );
                }else{
                    resultado.setText(resultado.getText() + "8" );
                }
            }
        } );

        btn9.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "9" );
                }else{
                    resultado.setText(resultado.getText() + "9" );
                }
            }
        } );

        btn0.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText() == null) {
                    resultado.setText( "0" );
                }else{
                    resultado.setText(resultado.getText() + "0" );
                }
            }
        } );

    }

    public String somar(){
        return String.valueOf(valor1 + valor2);
    }
    public String subtrair(){
        return String.valueOf(valor1 - valor2);
    }
    public String multiplicar(){
        return String.valueOf(valor1 * valor2);
    }
    public String dividir(){
        return String.valueOf(valor1 / valor2);
    }
}
