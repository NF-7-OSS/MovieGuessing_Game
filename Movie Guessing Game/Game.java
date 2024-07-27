import java.util.Objects;

public class Game {
    public String choice;
    public String originalMovieName;
    public String guessedPart;
    public int lives;

    public Game(String computerChoice) {
        this.originalMovieName = computerChoice;
        this.choice = computerChoice.replaceAll("\\s", "").toLowerCase();
        this.guessedPart = "";
        this.lives = 10;
    }

    public void movieDescription() {
        System.out.println("the movie is " + choice.length() + " characters long.\nyou have 10 lives, after which the answer will be revealed!");
    }

    public int guessTheMovie(String chosenChar) {
        if (choice.contains(chosenChar) && !guessedPart.contains(chosenChar)) {
            for (int i = 0; i < choice.length(); i++) {
                if (Objects.equals(choice.split("", choice.length())[i], chosenChar))
                    guessedPart += chosenChar;
                if (guessedPart.contains(choice.split("", choice.length())[i])) {
                    System.out.print(" " + choice.split("", choice.length())[i] + " ");
                } else {
                    System.out.print(" _ ");
                }
            }
            if (guessedPart.length() == choice.length()) {
                System.out.println("\n\nCongratulations! you guessed it right.\nthe movies is: " + originalMovieName);
                lives = 0;
            }
        } else {
            if (lives > 1) {
                System.out.println("wrong guess! you have " + --lives + " lives left!");
            } else {
                System.out.println("Oops! you ran out of lives!\nthe movies is: " + originalMovieName);
                lives = 0;
            }
        }
        return lives;
    }
}
