package model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer usuario_id;
    private String nome;
    private String email;
    private String cidade;

    public Usuario() {
    }

    public Usuario(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Usuario(Integer usuario_id, String nome, String email, String cidade) {
        this.usuario_id = usuario_id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }

    public Usuario(String nome, String email, String cidade) {
        this.usuario_id = 0;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}
