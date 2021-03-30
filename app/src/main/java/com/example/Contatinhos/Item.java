package com.example.Contatinhos;

public class Item {
    private int idUser;
    private String name;
    private String address;
    private String phone;
    private String type;

    public Item(){}

    public Item(int idUser, String name, String address, String phone, String type){
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.type=type;
    }
    public int getIdUser(){
        return idUser;
    }
    public void setIdUser(int idUser){
        this.idUser=idUser;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }

    public String toString(){
        return name + '\n'+ address +'\n' + phone + '\n' + type;

    }





}
