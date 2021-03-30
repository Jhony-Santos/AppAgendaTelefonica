package com.example.Contatinhos;

import java.util.ArrayList;

public class UserSingleton {

    private static UserSingleton instante = new UserSingleton();

    public ArrayList<User> userDetails=new ArrayList<>();
    private int userIndex;

    private UserSingleton(){
        userIndex=0;
        userDetails.add(new User("jhonatan","jhonatan"));
    }

    public User getCurrentUser(){
        return userDetails.get(userIndex);
    }
    public String getIndexString(){
        return "" + (userIndex + 1) +"/" + userDetails.size();
    }

    public static UserSingleton getInstance(){
        return instante;
    }

}
