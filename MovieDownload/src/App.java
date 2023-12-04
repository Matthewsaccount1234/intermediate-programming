import java.util.ArrayList;
import java.util.Scanner;

class App {
    public static void main(String[] args) throws Exception {
        // 1. Create a new MoviePosterWriter
        MoviePosterWriter mpw = new MoviePosterWriter();
        // 2. Create a new Movie, pass it in a string of a movie title

        // Choose your own movies below and put them into this array! make a loop to
        // repeat steps 2 and 3.
        String[] movies = { "avengers", "inception" }; // initialize array
        String[] movies2 = new String[5]; // 2nd way to initialize array
        ArrayList<String> movies3 = new ArrayList(); // array list - do not specify size
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < movies.length; i++) {
            // TODO: change this for loop to a while loop
            // and run until someone types in STOP
            System.out.println("Tell me a movie:");
            movies3.add(sc.nextLine()); // adding
            // Movie avengers = new Movie(movies[i]); // getting for an array
            Movie avengers = new Movie(movies3.get(i)); // getting for an arraylist
            // 3. use the movie poster writer to set a movie and then write it
            mpw.setMovieString(avengers.getMovieNameForURL());
            mpw.write(avengers.getMovieFilename());
        }

        System.out.println("We have gotten all of these posters:");
        // TODO: Print out all movie names
        for (int i = 0; i < movies3.size(); i++) {
            System.out.println(movies3.get(i));
        }
        movies3.remove(0);
        System.out.println("Removed one movie");
        for (int i = 0; i < movies3.size(); i++) {
            System.out.println(movies3.get(i));
        }

        // REMOVE ALL THE MOVIES FROM movies3

    }
}