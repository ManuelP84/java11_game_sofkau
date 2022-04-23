package com.sofkau.models;

public class Player extends User{
    private int price ;
    private int levelArchive;
    private int currenLevel;

    public Player(String name) {
        super(name);
    }

    public Player(String name, int price, int levelArchive, int currenLevel) {
        super(name);
        this.price = price;
        this.levelArchive = levelArchive;
        this.currenLevel = currenLevel;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Player: " + getName() + " Price: " + price;
    }
}