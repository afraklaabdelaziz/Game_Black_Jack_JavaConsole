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
        //System.out.println(cartes);
        dealer.piocheCarte(cartes,this.palyer);
        //System.out.println(cartes);
        //System.out.println(cartes.size());
        //System.out.println("dealer : " + dealer.cartes);
        //System.out.println("player : " + palyer.cartes);
        this.hand();
    }


    public void hand(){
        if (palyer.score == 21){
            compareScorePlayerAndDealer();
        }else if(palyer.score > 21){
            System.out.println("vous avez perdu");
        }else{
            System.out.print("Player Carte :\t\t");
            palyer.afficheCarte();
            System.out.println(palyer.afficheScorePlayer());
            System.out.println("\n1 : tirer Une carte");
            System.out.println("2 : Stand");
            int choix = sc.nextInt();
            switch (choix){
                case 1 :
                    palyer.tirerCarte(cartes);
                    hand();
                    break;
                case 2 :
                    System.out.print("dealer Carte :\t\t");
                    dealer.afficheCarte();
                    compareScorePlayerAndDealer();
                    break;
            }
        }
    }

    public void compareScorePlayerAndDealer(){
        if (dealer.scoreDealer < 17){
            System.out.print("dealer Carte :\t\t");
            dealer.tirerCarte(cartes);
            dealer.afficheCarte();
        }
        else if(dealer.scoreDealer > 21){
            System.out.print("dealer Carte :\t\t");
            dealer.afficheCarte();
            System.out.println("Palyer win");
            // coins invester *2
        }
        else if(dealer.scoreDealer == palyer.score){
            System.out.print("dealer Carte :\t\t");
            dealer.afficheCarte();
            System.out.println("egalitee");
            // coins ne change pas
        }
        else if(dealer.scoreDealer > palyer.score ){
            System.out.print("dealer Carte :\t\t");
            dealer.afficheCarte();
            System.out.println("player win");
            // coins invester *2
        }
        else {
            System.out.print("dealer Carte :\t\t");
            dealer.afficheCarte();
            System.out.println("Dealer win");
        }
        // coins invester Dealer *2
    }



    public void afficheListe(){
        for (Carte carte : cartes){
         System.out.print(carte);
   }
    }

}
