import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("=== Welcome to Guess the Number Game ===");

        while (playAgain) {

            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Correct! You guessed the number.");
                    int points = 10 - (attempts - 1);
                    totalScore += points;
                    System.out.println("Points earned: " + points);
                    guessedCorrectly = true;
                    break;
                } 
                else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } 
                else {
                    System.out.println("Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Out of attempts!");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.println("Current Score: " + totalScore);

            System.out.print("\nDo you want to play another round? (Y/N): ");
            char choice = sc.next().charAt(0);

            if (choice != 'Y' && choice != 'y') {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Final Score: " + totalScore);
        sc.close();
    }
}
