package com.myapp.app.model;

import lombok.Getter;

@Getter
public class Menu {
    private final String name;
    private final Integer price;

    public Menu(String name, Integer price){
        this.name = name;
        this.price = price;
    }
}
