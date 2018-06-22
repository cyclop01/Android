package com.example.admin.luckycup.Beans;

/**
 * Created by Admin on 16/06/2018.
 */

public class Partida {

    private int Id_Partida;
    private int idsA;
    private int idsB;
    private int Data;
    private int Hora;

    public Partida(){

        Id_Partida = -1;
        idsA=0;
        idsB=0;;
        Data=0;
        Hora=0;

    }

    public int getId_Partida() {
        return Id_Partida;
    }

    public void setId_Partida(int id_Partida) {
        Id_Partida = id_Partida;
    }

    public int getIdsA() {
        return idsA;
    }

    public void setIdsA(int idsA) {
        this.idsA = idsA;
    }

    public int getIdsB() {
        return idsB;
    }

    public void setIdsB(int idsB) {
        this.idsB = idsB;
    }

    public int getData() {
        return Data;
    }

    public void setData(int data) {
        Data = data;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int hora) {
        Hora = hora;
    }

}
