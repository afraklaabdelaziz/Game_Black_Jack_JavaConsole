package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Palyer palyer = new Palyer();
    private Dealer dealer = new Dealer();
    private ArrayList<Carte> cartes = new ArrayList<>();
    private ArrayList<Carte> carteDefausser = new ArrayList<>();
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

    public ArrayList<Carte> getCarteDefausser() {
        return carteDefausser;
    }

    public void setCarteDefausser(ArrayList<Carte> carteDefausser) {
        this.carteDefausser = carteDefausser;
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
        palyer.name = sc.next();
        this.creteInfoPlayer();
        this.creeCartes();
        dealer.mellangerCartes(getCartes());
        //System.out.println(cartes);
        dealer.piocheCarte(cartes,this.palyer);
        //System.out.println(cartes);
        //System.out.println(cartes.size());
        //System.out.println("dealer : " + dealer.cartes);
        //System.out.println("player : " + palyer.cartes);
        System.out.println("Bien venu   " + palyer.name);
        System.out.println("vous avez invester  " + palyer.getCoinInvester());
        this.hand();
    }


    public void hand(){
        System.out.println("Dealer Carte :  " + dealer.cartes.get(0));
        palyer.calculerScorePlayer();
        System.out.println("Votre score est : "+palyer.score);
        if (palyer.score == 21){
            System.out.print("Player Carte :\t\t");
            palyer.afficheCarte();
            compareScorePlayerAndDealer();
        }else if(palyer.score > 21){
            System.out.print("Player Carte :\t\t");
            palyer.afficheCarte();
            System.out.println("vous avez perdu");
            palyer.setCoinss(palyer.getCoinss() - palyer.getCoinInvester());
            this.replay();
        }else{
            System.out.print("Player Carte :\t\t");
            palyer.afficheCarte();
            System.out.println("\n1 : tirer Une carte");
            System.out.println("2 : Stand");
            int choix = sc.nextInt();
            switch (choix){
                case 1 :
                    palyer.tirerCarte(cartes);
                    hand();
                    break;
                case 2 :
                    compareScorePlayerAndDealer();
                    break;
            }
        }
    }

    public void compareScorePlayerAndDealer(){
        dealer.calculerScoreDealer();
        System.out.println("dealer Carte :\t\t" + dealer.cartes);
        System.out.println("Score de dealer est : " + dealer.score);

        if (dealer.score < 17){
            dealer.tirerUneCarte(cartes);
            compareScorePlayerAndDealer();
        }
        else if(dealer.score > 21){
            System.out.println("Palyer win");
            palyer.setCoinss(palyer.getCoinss() + palyer.getCoinInvester());
            this.replay();
        }
        else if(dealer.score == palyer.score){
            System.out.println("egalitee");
            this.replay();
        }
        else if(dealer.score < palyer.score ){
            System.out.println("player win");
            palyer.setCoinss(palyer.getCoinss() + palyer.getCoinInvester());
            this.replay();
        }
        else if(dealer.score == 21){
            System.out.println("dealer win");
            palyer.setCoinss(palyer.getCoinss() - palyer.getCoinInvester());
            this.replay();
        }
        else if (dealer.score < 21 && palyer.score == 21){
            System.out.println("player win");
            palyer.setCoinss(palyer.getCoinss() + palyer.getCoinInvester());
            this.replay();
        }
        else {
            System.out.println("Dealer win");
            palyer.setCoinss(palyer.getCoinss() - palyer.getCoinInvester());
            this.replay();
        }

    }

    public void replay(){
        System.out.println("\nVotre Score est : " + palyer.getCoinss());
        System.out.println("1 : replay");
        System.out.println("2 : quiter");
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                this.creteInfoPlayer();
                dealer.defausserCarte(getCarteDefausser(),palyer);
                dealer.piocheCarte(cartes,palyer);
                this.hand();
                break;
        }
    }


    public void creteInfoPlayer(){
        System.out.println("Votre Coins = " + palyer.getCoinss());
        System.out.println("Choisir valeur de coins que tu va invester");
        System.out.println("1 : pour 500 coins");
        System.out.println("2 : pour 1000 coins");
        System.out.println("3 : pour 3000 coins");
        int choix = sc.nextInt();
        switch (choix){
            case 1 :
                palyer.setCoinInvester(500);
                break;
            case 2 :
                palyer.setCoinInvester(1000);
                break;
            case 3 :
                palyer.setCoinInvester(3000);
                break;
        }
    }


    public void afficheListe(){
        for (Carte carte : cartes){
         System.out.print(carte);
   }
    }

}
