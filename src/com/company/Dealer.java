package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Dealer extends Person {
    ArrayList<Carte> cartesDealer = new ArrayList();
    public Dealer(){
        super();
    }
    public Dealer(String name, int coins, ArrayList carte) {
        super(name, coins, carte);
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

    public ArrayList piocheCarte(ArrayList<Carte> cartePioche){
        this.cartesDealer.add(cartePioche.get(0));
        this.getCarte().add(cartePioche.get(1));
        this.getCarte().add(cartePioche.get(2));
        cartePioche.remove(0);
        cartePioche.remove(0);
        cartePioche.remove(0);
        return cartePioche;
    }


    public void afficheCarte() {
        for (Carte carte : cartesDealer) {
            System.out.println(carte);
        }
    }

        public void afficheScoreDealer(){
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
