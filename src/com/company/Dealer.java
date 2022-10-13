package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dealer extends Person {
    public Dealer(){
        super();
    }
    public Dealer(String name, int coins, ArrayList carte,int score) {
        super(name, coins, carte,score);
    }

    public void mellangerCartes(ArrayList cartes){
        ArrayList carteMelanger = new ArrayList<>();
        for(int i = 0 ; i < 52 ; i++){
            ArrayList carteee = tirerCarte(cartes);
        carteMelanger = (ArrayList) carteee.get(1);
        carteMelanger.add(carteee.get(0));
    }
    }

   public ArrayList tirerCarte(ArrayList carteT){
       Random r = new Random();
       int n = r.nextInt(52);
       return extraireIemeCarte(carteT,n);
    }

    public ArrayList extraireIemeCarte(ArrayList<Carte> cartess , int n){
        ArrayList listeCarte = new ArrayList<>();
        Carte carteTire;
         carteTire = cartess.get(n);
         cartess.remove(n);
        listeCarte.add(carteTire);
        listeCarte.add(cartess);
        return listeCarte;
    }

    public void piocheCarte(ArrayList<Carte> cartePioche,Palyer palyer){
        this.cartes.add(cartePioche.get(0));
        cartePioche.remove(0);
       palyer.cartes.add(cartePioche.get(0));
        cartePioche.remove(0);
        palyer.cartes.add(cartePioche.get(0));
        cartePioche.remove(0);
        this.cartes.add(cartePioche.get(0));
        cartePioche.remove(0);
    }


    public ArrayList tirerUneCarte(ArrayList<Carte> cartes){
        this.cartes.add(cartes.get(0));
        cartes.remove(0);
        return cartes;
    }



    public void afficheCarte() {
        System.out.println(this.cartes);
    }

    public void calculerScoreDealer(){
        int scoreTmp = this.score;
        this.score = 0;
        for (Carte carte : this.cartes){
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


    public void defausserCarte(ArrayList carteDefuaser,Palyer palyer){
        carteDefuaser.add(this.cartes);
        carteDefuaser.add(palyer.cartes);
        this.cartes.clear();
        palyer.cartes.clear();
        palyer.score = 0;
        this.score = 0;
    }

}
