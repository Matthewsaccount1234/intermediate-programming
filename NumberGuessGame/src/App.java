
//Matthew Fratepietro
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    // Declaring fields for the range of the number, creating the number, and the
    // number of guesses
    static int guesses = 0;
    static int range_min =0 ;
    static int range_max = 50;
    static Random rand = new Random();
    static int answer = rand.nextInt(range_min, range_max);
    static ArrayList<Integer> alreadyGuessed = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        // Begins program
        
        eval_guess(get_new_guess());

    }

    public static int get_new_guess() {
        System.out.println("Guess a number from " + range_min + " to " + range_max);
        // creates new scanner
        Scanner sc = new Scanner(System.in);
        // checks if the input is an integer
        if (sc.hasNextInt()) {
            // if input is an integer, it transfers the input to an integer and returns that
            // value
            String next_guess = sc.next();
            int guess_int = Integer.valueOf(next_guess);
            return guess_int;
        } else {
            // if input is not an integer, it recurses the function so that you can guess
            // again with no penalty to the number of guesses
            System.out.println("This is not an integer. Guess again.");
            get_new_guess();
            return 0;
        }
    }

    public static void eval_guess(int guess) {
        if (alreadyGuessed.contains(guess)) {
            System.out.println("You already guessed that");
            eval_guess(get_new_guess());
        } else {
            if (guess > answer) {
                // if the guess is higher than the answer, it tells the user to guess lower
                System.out.println("Lower. What is your next guess?");
                // adds a guess to guess counter
                guesses += 1;
                //adds guess to guessed list
                alreadyGuessed.add(guess);
                // reruns method to test next guess
                eval_guess(get_new_guess());
            } else if (guess < answer) {
                // if the guess is lower than the answer, it tells the user to guess higher
                System.out.println("Higher. What is your next guess?");
                // adds a guess to guess counter
                guesses += 1;
                //adds guess to guessed list
                alreadyGuessed.add(guess);
                // reruns method to test next guess
                eval_guess(get_new_guess());
            } else {
                // if the user gets the right answer, game ends and the guesses are printed
                System.out.println("congratulations you got the answer in " + guesses + " guesses");
            }

        }
    }
}
