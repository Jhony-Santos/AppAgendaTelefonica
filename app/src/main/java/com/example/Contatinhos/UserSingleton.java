package com.example.Contatinhos;

import java.util.ArrayList;

public class UserSingleton {

    private static UserSingleton instante = new UserSingleton();

    public ArrayList<User> userList=new ArrayList<>();
    public User currentUser;
    public int userIndex;

    private UserSingleton(){ }

    public User getCurrentUser(){
        currentUser=userList.get(userIndex);
        return currentUser;
    }

    public static UserSingleton getInstance(){
        return instante;
    }

}
