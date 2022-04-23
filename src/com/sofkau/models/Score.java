package com.sofkau.models;

import com.sofkau.interfaces.IUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Score implements IUtilities {
    private Player[] players = new Player[5];

    public Score(){
        players[0] = new Player("manuel");
        players[1] = new Player("manuel");
        players[2] = new Player("manuel");
        players[3] = new Player("manuel");
        players[4] = new Player("manuel");
    }

    @Override
    public void showMenu() {
        System.out.println(" BIENVENIDOS A HIGH SCORE");
        System.out.println("1.ULTIMOS MEJORES PUNTAJES");
        System.out.println("2.VOLVER AL MENU PRINCIPAL");
        System.out.println("3.SALIR");
    }

    @Override
    public void requestOption() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("INGRESA UNA OPCION: ");
        int opcion=0;
        try {
             opcion = keyboard.nextInt();

        }catch (InputMismatchException e){
            System.out.print("POR FAVOR INGRESA UN NUMERO ENTRE 1 Y 3 ");
            showMenu();
            requestOption();
        }
        switch (opcion){
            case 1:
                System.out.println("**********SCORE**********");
                showScore();
                showMenu();
                break;
            case 2:
                System.out.print("menu principal");
                break;
            case 3:
                System.out.print("salir");
            default:
                System.out.print("POR FAVOR INGRESA UN NUMERO ENTRE 1 Y 3, GRACIAS");
                showMenu();
                requestOption();
        }
    }

    public void showScore(){
        for (Player player : players){
            System.out.println(player);
        }
    }

    public void addScorePlayer(Player player){
        int counter1 = 0;
        while (counter1 < players.length){
            if(player.getPrice() > players[counter1].getPrice()){
                int counter2 = counter1;
                while (counter2 < players.length){
                    Player temp_player = players[counter2];
                    players[counter2] = player;
                    player = temp_player;
                    counter2++;
                }
            }
            counter1++;
        }
    }
}
