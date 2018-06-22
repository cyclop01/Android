package com.example.admin.luckycup.Beans;

/**
 * Created by Admin on 17/06/2018.
 */

public class Usuario {
    private String Login;
    private String Senha;

    public Usuario(){
        Login = "";
        Senha = "";
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
