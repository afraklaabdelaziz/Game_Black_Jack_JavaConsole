package com.company;

import java.util.ArrayList;

    public class Palyer extends Person

    {
       private int coinInvester = 0;
       private int coins = 15000;

       public Palyer(){}


            public Palyer(String name,ArrayList<Carte> carte,int score,int coinInvester,int coins)

            {
                super(name,carte,score);

                this.coinInvester = coinInvester;
                this.coins = coins;
            }


            public int getCoinInvester()

            {
                return coinInvester;
            }


            public void setCoinInvester(int coinInvester)

            {
                this.coinInvester = coinInvester;
            }


            public int getCoinss()

            {
                return coins;
            }


            public void setCoinss(int coinss)

            {
                this.coins = coinss;
            }


            public void afficheCarte()

            {
                for (Carte carte : getCarte())
                {
                    System.out.print(carte+"\t");
                }
            }


          public void calculerScorePlayer()

          {
            int scoreTmp = this.score;
            this.score = 0;

                 for (Carte carte : getCarte())
                 {
                          if (carte.getHauteur() == 1 && scoreTmp >= 10)
                          {
                              this.score += carte.getHauteur();
                              scoreTmp = scoreTmp - 10;
                          }

                         else if (carte.getHauteur() == 1 && this.score <= 10)
                         {
                             this.score += 11;
                         }

                         else if (carte.getHauteur() == 11 || carte.getHauteur() == 12 || carte.getHauteur() == 13)
                         {
                             this.score += 10;
                         }

                         else
                         {
                             this.score += carte.getHauteur();
                         }

                 }

          }


    }
