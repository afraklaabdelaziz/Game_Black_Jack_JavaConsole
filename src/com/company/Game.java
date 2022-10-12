package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Palyer palyer = new Palyer();
    private Dealer dealer = new Dealer();
    private ArrayList<Carte> cartes = new ArrayList<>();
     Scanner sc = new Scanner(System.in);

    public Palyer getPalyer() {
        return palyer;
    }

    public void setPalyer(Palyer palyer) {
        this.palyer = palyer;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }

    public void creeCartes(){
        for (int i = 1 ; i <= 4  ;i++){
            for (int j=1 ; j<= 13; j++){
                Carte carte = new Carte(j,i);
                this.cartes.add(carte);
            }
        }
    }

    public void startGame(){
        System.out.println("Entrer votre nom");
        String nom = sc.next();
        System.out.println("entrer coins que tu veux invester");
        int coins = sc.nextInt();
        this.creeCartes();
        dealer.mellangerCartes(getCartes());
        dealer.piocheCarte(getCartes());
        this.palyer.tirerCarte(cartes);

    }



    public void afficheListe(){
        for (Carte carte : cartes){
         System.out.println(carte);
   }
    }

}
