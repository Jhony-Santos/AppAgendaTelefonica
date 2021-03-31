package com.example.appagenda;

import java.util.ArrayList;

public class UsuarioSingleton {

    private static UsuarioSingleton instance = new UsuarioSingleton();

    public ArrayList<Usuario> usuarioList = new ArrayList();
    public Usuario currentUsuario;
    public int userIndex;

    private UsuarioSingleton() {}

    public UsuarioSingleton(ArrayList<Usuario> usuarioList, Usuario currentUsuario, int userIndex) {
        this.usuarioList = usuarioList;
        this.currentUsuario = currentUsuario;
        this.userIndex = userIndex;
    }

    public static UsuarioSingleton getInstance() {
        return instance;
    }

    public void addUserList(Usuario usuario) {
        usuarioList.add(usuario);
    }

    public Usuario getCurrentUsuario() {
        currentUsuario = usuarioList.get(userIndex);
        return currentUsuario;
    }

}
