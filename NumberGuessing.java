import java.util.Scanner;
import java.util.Random;

public class NumberGuessing {
    public static void main(String[] args) {
        int min_value = 1;// the least value the user can choose
        int max_value = 100;// the highest value the user can choose
        int maximum_Attempts = 5;// the maximum number of atttempts the user can perform
        int mark = 0;// the score of the user

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Guessing  the Number game !!!");// welcome msg to the user
        System.out.println(
                "I have picked  a number between " + min_value + " and " + max_value + ". hope if you can guess it!");// range
                                                                                                                      // specfied
        boolean playAgain = true;
        while (playAgain) {
            int randomNumber = random.nextInt(max_value - min_value + 1) + min_value;
            int attempts = 0;
            boolean guessedCorrectly = false;
            while (!guessedCorrectly && attempts < maximum_Attempts) {
                System.out.print("Enter your guessed number in the range 1 to 100: ");// to enter the number btw 1 to
                                                                                      // 100
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == randomNumber) {
                    System.out.println("Well done! You've successfully guessed the correct number.");// output to the
                                                                                                     // user
                    mark += (maximum_Attempts - attempts + 1); // Increase score based on remaining attempts
                    guessedCorrectly = true;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guessed number  is lower than the generated number.");
                } else {
                    System.out.println("Your guessed number  is higher than the generated number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Unfortunately, you've exhausted all your attempts. The number was " + randomNumber);
            }

            System.out.println("Your current score: " + mark);// current score
            System.out.print("Do you want to play again? (y/n): ");// option to user if he want to play again
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Guess the Number!");
    }
}
