import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to a game of Mastermind!\n");
        Difficulty.printDifficultyList();
        System.out.println();
        System.out.println("Please choose your difficulty level:");

        // get user input on difficulty level
        String input = "";
        while (!isDifficulty(input)) {
            System.out.print("> ");
            input = scanner.next();
        }
        Difficulty difficultyLevel = Difficulty.valueOf(input.toUpperCase());
        System.out.println(difficultyLevel + " mode chosen");;

        // instantiate the board with difficulty level chosen (#rows and #colors)
        Board board = new Board(difficultyLevel);

        // game start (while loop)
        boolean gameOn = true;
        while (gameOn) {
            // prompt for user answer input
            String userGuess = "";
            

            // check input validity
            // generate feedbackRow
            // check for win (4 greens in feedback)
            // repeat loop
        }





        scanner.close();
    }

    // check if string is Difficulty enum
    public static boolean isDifficulty(String input) {
        boolean result = false;
        Difficulty difficulty = null;
        try {
            difficulty = Difficulty.valueOf(input.toUpperCase());
        } catch (Exception e) {
            result = false;
        }
        if (difficulty != null) {
            result = true;
        }
        return result;
    }

    // generate feedbackRow

}