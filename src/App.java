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
        System.out.println(input.toUpperCase() + " mode chosen");
        Difficulty difficultyLevel = Difficulty.valueOf(input);





        scanner.close();
    }

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
}