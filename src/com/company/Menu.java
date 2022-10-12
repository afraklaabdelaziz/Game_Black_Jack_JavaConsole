package com.company;

import java.util.Scanner;

public class Menu {
    public void menuPricipal(){
        Game game = new Game();
        Scanner sc = new Scanner(System.in);
        System.out.println("1 : star le jeu");
        System.out.println("2 : star le jeu");
        System.out.println("pour quiter clic sur une button");
        int choix = sc.nextInt();
        switch (choix){
            case 1 : game.startGame();
            break;
        }
    }
}
