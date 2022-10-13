package com.company;

import java.util.ArrayList;

public class Palyer extends Person{
   private int coinInvester = 0;
   private int coinss = 15000;
public Palyer(){}
    public Palyer(String name, int coins, ArrayList<Carte> carte,int score,int coinInvester,int coinss) {
        super(name,coins, carte,score);

        this.coinInvester = coinInvester;
        this.coinss = coinss;
    }

    public int getCoinInvester() {
        return coinInvester;
    }

    public void setCoinInvester(int coinInvester) {
        this.coinInvester = coinInvester;
    }

    public int getCoinss() {
        return coinss;
    }

    public void setCoinss(int coinss) {
        this.coinss = coinss;
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

    public void calculerScorePlayer(){
    int scoreTmp = this.score;
    this.score = 0;
     for (Carte carte : getCarte()){
          if (carte.getHauteur() == 1 && scoreTmp >= 10){
              this.score += carte.getHauteur();
              scoreTmp = scoreTmp - 10;
         }
         else if (carte.getHauteur() == 1 && this.score <= 10){
             this.score += 11;
         }
         else if (carte.getHauteur() == 11 || carte.getHauteur() == 12 || carte.getHauteur() == 13){
             this.score += 10;
         }else{
             this.score += carte.getHauteur();
         }
     }
    }


}
