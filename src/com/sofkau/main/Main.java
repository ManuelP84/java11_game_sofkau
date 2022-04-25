package com.sofkau.main;

import com.sofkau.interfaces.IUtilities;
import com.sofkau.models.Game;
import com.sofkau.models.Player;
import com.sofkau.models.Score;
import com.sofkau.questions.QuestionCollection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.sofkau.models.Question;


public class Main implements IUtilities {

    public static void main(String[] args) {
        List<List<Question>> totalQuestions = new ArrayList<>();
        totalQuestions = QuestionCollection.populateQuestionList();
        Integer option=0;

        // Instanciamos objetos
        Game game  = new Game();
        Score score = new Score();

        Player player = new Player();
        player.requestName();

        do {
            showMenu();
            option = requestOption();
            {
                switch (option){
                    case 1:
                        Integer optionGame = 0;
                        game.showMenu();
                        optionGame = game.requestOption();
                        game.gameCycle(optionGame, player, score, totalQuestions);
                        // Logiga de Game
                        // ciclo
                        break;
                    case 2:
                        Integer opcionScore=0;
                        score.showMenu();
                        opcionScore = score.requestOption();
                        score.scoreUser();
                        score.cicloScore(opcionScore);

                        // score.cicloSclo(opcion);
                        // Menu:
                        // Bienvenidos
                        // 1. Ver ranking
                        // 2. Salir
                        // score.requestOption()
                        // Logica de Score
                        break;
                    case 3:
                        System.exit(0);
                        break;
                }
            }
        }
        while(true);
    }

    public static void showMenu() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println("***********************************\n***********-BIENVENIDOS-***********\n***********************************\n");
        System.out.println();
        System.out.println("POR FAVOR, SIGUE  LAS INSTRUCCIONES DE  LA CONSOLA ");
        System.out.println();
        System.out.println("-1. COMENZAR UN NUEVO JUEGO");
        System.out.println("-2. PUNTAJES ALTOS");
        System.out.println("-3. SALIR");
        System.out.println();
    }

    public static Integer requestOption() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("INGRESA UNA OPCIÓN: ");
        int opcion=0;
        try {
            opcion = keyboard.nextInt();

        }catch (InputMismatchException e){
            System.out.print("POR FAVOR, INGRESA UN NUMERO ENTRE 1 Y 3: ");
        }
    return opcion;
    }
}
