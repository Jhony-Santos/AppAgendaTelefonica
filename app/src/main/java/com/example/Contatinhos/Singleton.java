package com.example.Contatinhos;



import java.util.ArrayList;

public class Singleton {
    public static Singleton instance = new Singleton();
    public ArrayList<Item> listItens=new ArrayList<>();

    public static Singleton getInstance(){
        return instance;
    }

    public void CreatedItem(Item item){
        listItens.add(item);
    }
    public ArrayList<Item> getListItens(){
        return listItens;
    }


}
