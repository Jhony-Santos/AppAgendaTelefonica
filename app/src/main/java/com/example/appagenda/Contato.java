package com.example.appagenda;

public class Contato {

    private int idUsuario;
    private String nome;
    private String endereco;
    private String telefone;
    private String tipo;

    public Contato() {
    }

    public Contato(int idUser, String name, String address, String phone, String type) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public int getIdUser() {
        return idUsuario;
    }

    public void setIdUser(int idUser) {
        this.idUsuario = idUser;
    }

    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = nome;
    }

    public String getAddress() {
        return endereco;
    }

    public void setAddress(String address) {
        this.endereco = endereco;
    }

    public String getPhone() {
        return telefone;
    }

    public void setPhone(String phone) {
        this.telefone = telefone;
    }

    public String getType() {
        return tipo;
    }

    public void setType(String type) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return idUsuario + ";" +
                nome + ";" +
                endereco + ";" +
                telefone + ";" +
                tipo + ";";

    }
}
