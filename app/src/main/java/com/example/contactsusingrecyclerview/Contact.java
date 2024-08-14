package com.example.contactsusingrecyclerview;
// custom data type for contacts

public class Contact {
    int img;
    String name, number;

    public Contact(int img, String name, String number){
        this.name=name;
        this.number=number;
        this.img = img;
    }
}
