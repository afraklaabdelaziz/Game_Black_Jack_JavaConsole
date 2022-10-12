package com.company;

import java.util.ArrayList;

public class Palyer extends Person{
    int score = 0;

public Palyer(){}
    public Palyer(String name, int coins, ArrayList<Carte> carte) {
        super(name, coins, carte);
    }

    public ArrayList tirerCarte(ArrayList<Carte> cartes){
        this.cartes.add(cartes.get(0));
        cartes.remove(0);
        return cartes;
    }

    public void afficheCarte(){
        for (Carte carte : getCarte()){
            System.out.print(carte+"\t");
        }
    }

    public void afficheScorePlayer(){
     for (Carte carte : getCarte()){
         score += carte.getHauteur()+10;
     }
        System.out.println(score);
    }

    public void afficheCoinsPlayer(){
        System.out.println(getCoins());
    }

}
