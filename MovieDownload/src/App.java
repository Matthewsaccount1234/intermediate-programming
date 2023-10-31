
class App {
    public static void main(String[] args) throws Exception {
        // 1. Create a new MoviePosterWriter
        MoviePosterWriter mpw = new MoviePosterWriter();
        String [] movies = {"Avengers", "Jaws", "Star Wars", "Sixth Sense", "A Christmas Story"};
        // 2. Create a new Movie, pass it in a string of a movie title
        
        // 3. use the movie poster writer to set a movie and then write it

        for (int loopCounter = 0; loopCounter < movies.length; loopCounter++) {
            Movie movie = new Movie(movies[loopCounter]);
            mpw.setMovieString(movie.getMovieNameForURL());
            mpw.write(movie.getMovieFilename() + loopCounter + ".jpg");
        }


        // Choose your own movies here! make a loop to repeat steps 2 and 3.
        // String movies = {"avengers"};

        // this code doesn't work if you have a space in the movie name. see below
        // Movie airbud = new Movie("air bud");
        // mpw.setMovieString("air bud");
        // mpw.write("air bud");

    }
}
