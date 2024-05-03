
import java.util.Random;
import java.util.Scanner;



import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;

public interface Game {
    String getGameName();

    void play(); // must be able to play a game

    String getScore(); // get a score - if there is no "score" you can return return "N/A" or something.

    void writeHighScore(File f); // writes the high score of this game to a file.
}

