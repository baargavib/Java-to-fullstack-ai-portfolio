import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random()); // Generate a random number between 1 and 100
        int maxTrials = 5; // Maximum number of trials

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've chosen a number between 1 and 100.");
        System.out.println("You have " + maxTrials + " trials to guess it.");

        for (int trial = 1; trial <= maxTrials; trial++) {
            System.out.print("Guess #" + trial + ": ");
            int guess = scanner.nextInt();

            if (guess == number) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (guess < number) {
                System.out.println("Too low. Try a higher number.");
            } else {
                System.out.println("Too high. Try a lower number.");
            }
        }

        System.out.println("The correct number was: " + number);
        System.out.println("Thanks for playing!");
    }
}
