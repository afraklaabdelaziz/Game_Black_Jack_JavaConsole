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

    public int afficheScorePlayer(){
     for (Carte carte : getCarte()){
         if (carte.getHauteur() == 1 && carte.getHauteur() < 10){
             this.score += 11;
         }
         else if (carte.getHauteur() == 11 || carte.getHauteur() == 12 || carte.getHauteur() == 13){
             this.score += 10;
         }else{
             this.score += carte.getHauteur();
         }
     }
        return this.score;
    }

    public void afficheCoinsPlayer(){
        System.out.println(getCoins());
    }

}
