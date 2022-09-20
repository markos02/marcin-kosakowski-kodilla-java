package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class RpsGame {

    String playerName;
    int numberWins;
    int playerScore;
    int computerScore;
    boolean quitGame;
    Scanner scanner = new Scanner(System.in);

    public void startNewGame() {

        playerScore = 0;
        computerScore = 0;
        quitGame = false;

        System.out.println("\nNEW GAME");
        System.out.print("What is your name: ");
        playerName = scanner.next();

        System.out.print("How many rounds to win: ");
        numberWins = scanner.nextInt();

        System.out.println("\n\nInstructions:\n" +
                "Press 1 to play 'Rock'\n" +
                "Press 2 to play 'Paper'\n" +
                "Press 3 to play 'Scissors'\n" +
                "Press x to end the game\n" +
                "Press n to restart the game\n"
        );

        while (!quitGame) {
            playRound();
        }

        System.out.println("\nPress x to end the game\n" +
                "Press n to start new game");

        String choice = scanner.next();

        switch (choice) {
            case "x" -> {
                System.out.println("\nThanks for playing!");
                System.exit(0);
            }
            case "n" -> startNewGame();
        }
    }

    private void playRound() {

        System.out.print("\nMake your move: ");
        String playerMove = scanner.next();
        int computerMove;


        switch (playerMove) {
            case "1":
                computerMove = getComputerMove();
                switch (computerMove) {
                    case 1 -> System.out.println("It's a tie");
                    case 2 -> {
                        System.out.println("Computer wins round");
                        computerScore++;
                    }
                    case 3 -> {
                        System.out.println("Player wins round");
                        playerScore++;
                    }
                }
                System.out.println("(SCORE: Player- " + playerScore + ", Computer- " + computerScore + ")");
                break;
            case "2":
                computerMove = getComputerMove();
                switch (computerMove) {
                    case 1 -> {
                        System.out.println("Player wins round");
                        playerScore++;
                    }
                    case 2 -> System.out.println("It's a tie");
                    case 3 -> {
                        System.out.println("Computer wins round");
                        computerScore++;
                    }
                }
                System.out.println("(SCORE: Player- " + playerScore + ", Computer- " + computerScore + ")");
                break;
            case "3":
                computerMove = getComputerMove();
                switch (computerMove) {
                    case 1 -> {
                        System.out.println("Computer wins round");
                        computerScore++;
                    }
                    case 2 -> {
                        System.out.println("Player wins round");
                        playerScore++;
                    }
                    case 3 -> System.out.println("It's a tie");
                }
                System.out.println("(SCORE: Player- " + playerScore + ", Computer- " + computerScore + ")");
                break;
            case "x":
                System.out.print("Do you really want to quit [y/n]: ");
                if (scanner.next().equals("y")) {
                    System.out.println("\nThanks for playing!");
                    System.exit(0);
                }
                break;
            case "n":
                System.out.print("Do you really want to restart the game [y/n]: ");
                if (scanner.next().equals("y")) {
                    startNewGame();
                }
                break;
        }

        if (playerScore == numberWins) {
            System.out.println("\n" + playerName + " wins!");
            quitGame = true;
        }

        if (computerScore == numberWins) {
            System.out.println("\nComputer wins!");
            quitGame = true;
        }
    }

    private int getComputerMove() {
        Random random = new Random();
        int computerMove = 1 + random.nextInt(3);
        System.out.print("Computer move is: ");
        switch (computerMove) {
            case 1 -> System.out.println("Rock");
            case 2 -> System.out.println("Paper");
            case 3 -> System.out.println("Scissors");
        }
        return computerMove;
    }
}
