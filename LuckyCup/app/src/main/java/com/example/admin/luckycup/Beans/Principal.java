package com.example.admin.luckycup.Beans;

/**
 * Created by Admin on 17/06/2018.
 */

public class Principal {
    private int Id_Palpite;
    private int Id_Partida;
    private String Nome;
    private int gsA;
    private int gsB;

    public Principal(){

        Id_Palpite = -1;
        Id_Partida = 0;
        Nome = "";
        gsA=0;
        gsB=0;

    }

    public int getId_Palpite() {
        return Id_Palpite;
    }

    public void setId_Palpite(int id_Palpite) {
        Id_Palpite = id_Palpite;
    }

    public int getId_Partida() {
        return Id_Partida;
    }

    public void setId_Partida(int id_Partida) {
        Id_Partida = id_Partida;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getGsA() {
        return gsA;
    }

    public void setGsA(int gsA) {
        this.gsA = gsA;
    }

    public int getGsB() {
        return gsB;
    }

    public void setGsB(int gsB) {
        this.gsB = gsB;
    }
}
