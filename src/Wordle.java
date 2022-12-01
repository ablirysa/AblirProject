/**
 * The Wordle class represents a game where the user goes guesses words and is informed of which letters are wrong or right.
 */

public class Wordle {
    /** This is the player's name */
    private String name;
    /** This is the answer players will try to get */
    private String answer;
    /** This is the letters that do not exist in the answer that the player has tried */
    private String gray;
    /** This is the mode/hardness that the players selected */
    private String level;
    /** This is the amount of guesses players have taken until they get to the answer */
    private int guesses = 0;
    /** This is the amount of points players obtained from playing */
    private int points = 0;

    /** Default constructor that initializes the level to the easiest mode and their name to UNKNOWN */
    public Wordle() {
        level = "EASY";
        name = "UNKNOWN";
    }

    /** Two parameter constructor that initializes their level and name to their preference */
    public Wordle(String name, int mode) {
        this.name = name;
        if (mode == 1) {
            level = "EASY";
        } else if (mode == 2) {
            level = "MEDIUM";
        } else {
            level = "HARD";
        }
    }

    /** Gets the answer through chance (selection depends on level)
     @return String - the answer
     */
    public String wordRandomizer() {
        int num = (int) (Math.random() * 3) + 1;

        if (level.equals("EASY")) { /* 4-letter words */
            if (num == 1) {
                answer = "fast";
            } else if (num == 2) {
                answer = "stat";
            } else {
                answer = "bunt";
            }
        } else if (level.equals("MEDIUM")) { /* 5-letter words */
            if (num == 1) {
                answer = "viper";
            } else if (num == 2) {
                answer = "corny";
            } else {
                answer = "study";
            }
        } else { /* 6-letter words */
            if (num == 1) {
                answer = "throne";
            } else if (num == 2) {
                answer = "online";
            } else {
                answer = "acting";
            }
        }

        return answer;
    }

    /** Single parameter method that decides if the player's guess is correct
     @param guess - user's input/attempt
     @return boolean - true if guess is equal to answer
     */
    public boolean check(String guess) {
        guess = guess.toLowerCase();
        if (guess.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    /** Increases the amount of guesses the player has taken */
    public void plusGuess() {
        guesses++;
    }

    /** Single parameter method that decides the letters that are green, yellow, or gray in a player's guess
     @param guess - user's input/attempt
     */
    public void letterCheck(String guess) {
        guess = guess.toLowerCase();
        String green = "";
        String yellow = "";
        int i;

        // FIND SOLUTION FOR DOUBLE LETTERS
        for (i = 0; i <= answer.length() - 1; i++) {
            String tempG = guess.substring(0, 1);
            if (answer.indexOf(tempG) == -1) {
                gray += tempG;
            } else if (answer.indexOf(tempG) == 0) {
                green += tempG;
                answer = answer.substring(1);
            } else {
                yellow += tempG;
            }

            guess = guess.substring(1);
        }
    }
}
