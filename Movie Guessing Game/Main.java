import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\Projects\\Movie Guessing Game\\movies.txt");
        Scanner sc = new Scanner(file);
        String[] movies = new String[50];
        int movieCount = 0;

        //assigning values to movies array form movies.txt file
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            //storing movies extracted from the text file in an array
            movies[movieCount++] = line;
        }

        String[] moviesArray = new String[movieCount];
        //copying movie names from the initial movies array to the latest moviesArray (thus removing any null values)
        System.arraycopy(movies, 0, moviesArray, 0, movieCount);

        //getting a random movie name each time we restart the program
        String randomMovie = moviesArray[(int) (Math.random() * movieCount)];

        System.out.println("\t----- GUESS THE MOVIE -----\n");

        //feeding random movie name to the myGame obj, so to start the game
        Game myGame = new Game(randomMovie);

        //printing short description of the random movie
        myGame.movieDescription();

        int totalLives = 10;
        Scanner scanner = new Scanner(System.in);

        while (totalLives > 0) {
            System.out.println("\nGuess the character!....");
            String chosenChar = scanner.nextLine();
            totalLives = myGame.guessTheMovie(chosenChar.toLowerCase());
        }
        scanner.close();
        sc.close();
    }
}
