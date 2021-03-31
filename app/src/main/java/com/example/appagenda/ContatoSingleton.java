package com.example.appagenda;

import java.util.ArrayList;

public class ContatoSingleton {

    private static ContatoSingleton instace = new ContatoSingleton();

    public ArrayList<Contato> listItems = new ArrayList<>();

    public int itemIndex;

    public static ContatoSingleton getInstance() {
        return instace;
    }

    public void createItem(Contato item) {
        listItems.add(item);
    }

    public void updateItem(Contato item) {
        listItems.set(itemIndex, item);
    }

    public ArrayList<String> getFilteredListItem() {

        ArrayList<String> list = new ArrayList<>();

        int userIndex = UsuarioSingleton.getInstance().userIndex;
        for(Contato item : listItems) {
            if(item.getIdUser() == userIndex) {
                list.add(item.getName());
            }
        }

        return list;
    }

    public int getPositionUpdate(int positionListView) {

        int contByUser = -1;
        int contByFile = -1;
        int positionUpdate = -1;
        int userIndex = UsuarioSingleton.getInstance().userIndex;

        for(Contato item : listItems) {
            contByFile++;
            if(item.getIdUser() == userIndex) {
                contByUser++;
                if(contByUser == positionListView) {
                    positionUpdate = contByFile;
                    break;
                }
            }
        }

        return positionUpdate;

    }
}
