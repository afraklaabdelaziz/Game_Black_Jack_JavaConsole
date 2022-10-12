package com.company;

import java.util.ArrayList;

public class Person {
    private String name;
    private int coins;
    private ArrayList<Carte> cartes = new ArrayList();

    public Person(String name, int coins, ArrayList carte) {
        this.name = name;
        this.coins = coins;
        this.cartes = carte;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Carte> getCarte() {
        return cartes;
    }

    public void setCarte(ArrayList carte) {
        this.cartes = carte;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", coins=" + coins +
                ", carte=" + cartes +
                '}';
    }
}

