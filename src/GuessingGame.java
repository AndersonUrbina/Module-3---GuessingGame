//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public GuessingGame() {
    }

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        IO.println("Welcome to the Number guessing Game");

        while(playAgain) {
            int maxNumber = chooseDifficulty(input);
            playGame(input, random, maxNumber);
            playAgain = playAgain(input);
        }

        input.close();
    }

    public static void playGame(Scanner input, Random random, int maxNumber) {
        int secretNumber = random.nextInt(maxNumber) - 1;
        int guess = 0;
        int attempts = 0;
        System.out.println();
        System.out.println("I'm thinking of a number between 1 and " + maxNumber + ".");

        while(guess != secretNumber) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            if (guess >= 1 && guess <= maxNumber) {
                ++attempts;
                if (guess < secretNumber) {
                    System.out.println("Too Low. Try again!");
                } else if (guess > secretNumber) {
                    System.out.println("Too High, Try again!");
                } else {
                    System.out.println("You guessed the number correctly!!");
                    IO.println("You guessed the number: " + secretNumber + " in " + attempts + " attempts.");
                }

                System.out.println();
            } else {
                System.out.println("Your guess is invalid! Please enter a number between 1 and 100.");
            }
        }

    }

    public static int chooseDifficulty(Scanner input) {
        System.out.println();
        System.out.println("Select from the Following Difficulty levels:");
        System.out.println("EASY = 1 to 50");
        System.out.println("MED = 1 to 100");
        System.out.println("HARD = 1 to 500");
        System.out.print("Enter your choice: ");

        int choice;
        for(choice = input.nextInt(); choice < 1 || choice > 3; choice = input.nextInt()) {
            System.out.println();
            System.out.print("Invalid choice! Please enter 1, 2, 3: ");
        }

        if (choice == 1) {
            return 50;
        } else if (choice == 2) {
            return 100;
        } else {
            return 500;
        }
    }

    public static boolean playAgain(Scanner input) {
        System.out.println("Would you like to play again? Enter y or n: ");

        String answer;
        for(answer = input.next(); !answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"); answer = input.next()) {
            System.out.println("Invalid answer. Please enter y or n: ");
        }

        return answer.equalsIgnoreCase("y");
    }
}
