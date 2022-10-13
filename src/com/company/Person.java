package com.company;

import java.util.ArrayList;

public class Person {
    protected String name;
    protected  ArrayList<Carte> cartes = new ArrayList();
    protected int score;

    public Person(String name, ArrayList carte,int score) {
        this.name = name;
        this.cartes = carte;
        this.score = score;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Carte> getCarte() {
        return cartes;
    }

    public void setCarte(ArrayList carte) {
        this.cartes = carte;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cartes=" + cartes +
                ", score=" + score +
                '}';
    }
}

