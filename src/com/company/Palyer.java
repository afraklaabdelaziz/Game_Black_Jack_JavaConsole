package com.company;

import java.util.ArrayList;

public class Palyer extends Person{

public Palyer(){}
    public Palyer(String name, int coins, ArrayList<Carte> carte) {
        super(name, coins, carte);
    }

    public ArrayList tirerCarte(ArrayList<Carte> cartes){
        this.getCarte().add(cartes.get(0));
        cartes.remove(0);
        return cartes;
    }

    public void afficheCarte(){
        for (Carte carte : getCarte()){
            System.out.println(carte);
        }
    }

    public void afficheScorePlayer(){
     int score = 0;
     for (Carte carte : getCarte()){
         score += carte.getHauteur();
     }
        System.out.println(score);
    }

    public void afficheCoinsDealer(){
        System.out.println(getCoins());
    }

}
