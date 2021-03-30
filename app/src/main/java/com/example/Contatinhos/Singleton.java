package com.example.Contatinhos;

import java.util.ArrayList;

public class Singleton {
    public static Singleton instance = new Singleton();
    public ArrayList<Item> listItens=new ArrayList<>();

    public int itemIndex;

    public static Singleton getInstance(){
        return instance;
    }

    public void CreatedItem(Item item){
        listItens.add(item);
    }
    public void updateItem(Item item){
        listItens.set(itemIndex, item);
    }

    public ArrayList<Item> getListItens(){

        ArrayList<Item> list=new ArrayList<>();

        int userIndex=UserSingleton.getInstance().userIndex;

        for(Item item:listItens){
            if(item.getIdUser()==userIndex){
                list.add(item);
            }

        }

        return list;
    }


}
