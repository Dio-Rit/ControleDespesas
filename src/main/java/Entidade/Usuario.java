/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author PC
 */
public class Usuario {

    private int id_usuario;
    private String nome;
    private String login;
    private String senha;
    private String x;

    public int getId() {
        return id_usuario;
    }

    public void setId(int id) {
        this.id_usuario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

}
