
import java.util.Random;
import java.util.Scanner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class NumberGuessGame implements GameWriteable {

    ArrayList<Integer> allGuesses = new ArrayList<Integer>();
    static int guesses = 1;
    static int range_min = 0;
    static int range_max = 50;
    static Random rand = new Random();
    static int answer = rand.nextInt(range_min, range_max);
    static ArrayList<Integer> alreadyGuessed = new ArrayList<Integer>();
    static HashMap<String, Integer> highscores = new HashMap<String, Integer>();

    @Override
    public String getGameName() {
        return "Number Guess Game";
    }

    @Override
    public void play() {

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

    public static String name() {
        System.out.println("What was your name");
        // creates new scanner
        Scanner hs = new Scanner(System.in);
        // checks if the input is an integer
        String name = hs.next();
        return name;
    }

    public static Boolean playAgain() {
        System.out.println("Type 1 to exit, Type 2 to play again");
        // creates new scanner
        Scanner ag = new Scanner(System.in);
        // checks if the input is an integer
        String answer = ag.next();
        if (answer.equals("1")) {
            return false;
        } else {
            return true;
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
                // adds guess to guessed list
                alreadyGuessed.add(guess);
                // reruns method to test next guess
                eval_guess(get_new_guess());
            } else if (guess < answer) {
                // if the guess is lower than the answer, it tells the user to guess higher
                System.out.println("Higher. What is your next guess?");
                // adds a guess to guess counter
                guesses += 1;
                // adds guess to guessed list
                alreadyGuessed.add(guess);
                // reruns method to test next guess
                eval_guess(get_new_guess());
            } else {
                // if the user gets the right answer, game ends and the guesses are printed
                System.out.println("congratulations you got the answer in " + guesses + " guesses");
                set_highscore(name(), guesses);
                // replay the game
                if (playAgain()) {
                    answer = rand.nextInt(range_min, range_max);
                    alreadyGuessed.clear();
                    guesses = 0;
                    System.out.println("starting new game");
                    eval_guess(get_new_guess());
                } else {
                    System.out.println("Your highscores are:" + highscores);
                }

            }

        }
    }

    public static void set_highscore(String name, int score) {
        highscores.put(name, score);

    }



    @Override
    public String getScore() {
        return Integer.toString(guesses);
    }

    @Override
    public boolean isHighScore(String score, String highscore) {
        if (highscore == null){
            highscore = "10000";
            return true;
        } else{
        if (Integer.parseInt(highscore) > Integer.parseInt(score)) {
            return true;
        }
        return false;
    }
    }
}
