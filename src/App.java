import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
        System.out.println(difficultyLevel + " mode chosen");
        ;
        System.out.println();

        // instantiate the board with difficulty level chosen (#rows and #colors)
        Board board = new Board(difficultyLevel);
        System.out.print("Possible colors: ");
        board.printPossibleColors();
        System.out.println("Number of rounds: " + board.getNumOfRows());

        // game start (while loop)
        boolean gameOn = true;
        int round = 1;
        while (gameOn && round <= board.getNumOfRows()) {
            // prompt for user answer input
            // check input validity
            String userGuess = "";
            System.out.println();
            System.out.println("Round " + round + " - Input your guess: ");
            while (!isValidGuess(userGuess, board.getPossibleColors())) {
                System.out.print("> ");
                userGuess = scanner.next();
            }

            // generate feedbackRow
            String[] feedback = generateFeedbackRow(userGuess, board.getDealerRow());
            for (String string : feedback) {
                System.out.print(string + " ");
            }
            System.out.println();

            // check for win (4 greens in feedback)
            if (hasWon(feedback)) {
                System.out.println("\nYou've won! Congratulations!");
                gameOn = false;
            } else {
                round ++;
            }

            // repeat loop (count number of rounds)
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

    // check if guess is valid [ASSUMES 4 CHARACTER INPUT]
    public static boolean isValidGuess(String guess, List<Colors> possibleColors) {
        boolean result = false;
        Colors color = null;
        // check if only 4 chars were inputted
        if (guess.length() == 4) {
            for (int i = 0; i < 4; i++) {
                try {
                    // check if input is indeed an enum Colors
                    color = Colors.valueOf(String.valueOf(guess.charAt(i)).toUpperCase());
                    // check if enum is within possible list of enums (from difficulty level)
                    if (possibleColors.contains(color)) {
                        result = true;
                    } else {
                        result = false;
                    }
                } catch (Exception e) {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    // generate feedbackRow
    public static String[] generateFeedbackRow(String guess, Colors[] dealerRow) {
        String[] feedbackRow = new String[4];
        // feedback counters
        int green = 0;
        int red = 0;
        int black = 0;
        // convert String guess to hashmap with count
        Map<String, Integer> guessMap = new HashMap<>();
        String placeholder = "";
        for (int i = 0; i < guess.length(); i++) {
            placeholder = guess.substring(i, i + 1).toUpperCase();
            if (guessMap.containsKey(placeholder)) {
                int value = guessMap.get(placeholder) + 1;
                guessMap.put(placeholder, value);
            } else {
                guessMap.put(placeholder, 1);
            }
        }
        // convert Colors[] to hashmap with count
        Map<String, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < dealerRow.length; i++) {
            placeholder = String.valueOf(dealerRow[i]);
            if (answerMap.containsKey(placeholder)) {
                int value = answerMap.get(placeholder) + 1;
                answerMap.put(placeholder, value);
            } else {
                answerMap.put(placeholder, 1);
            }
        }
        // compare both maps for total color count matches (+1 to red if match). black =
        // 4 minus red
        Set<String> answerKeys = answerMap.keySet();
        for (String string : answerKeys) {
            if (guessMap.containsKey(string)) {
                int numA = answerMap.get(string);
                int numG = guessMap.get(string);
                if (numA < numG) {
                    red += numA;
                } else {
                    red += numG;
                }
            }
        }
        black = 4 - red;
        // check for greens (index match)
        for (int i = 0; i < dealerRow.length; i++) {
            String ans = String.valueOf(dealerRow[i]).toUpperCase();
            String val = guess.substring(i, i + 1).toUpperCase();
            if (ans.equals(val)) {
                green++;
                red--;
            }
        }
        // convert green, red, black to String[4]
        int index = 0;
        for (int i = 0; i < green; i++) {
            feedbackRow[index++] = "GREEN";
        }
        for (int i = 0; i < red; i++) {
            feedbackRow[index++] = "RED";
        }
        for (int i = 0; i < black; i++) {
            feedbackRow[index++] = "BLACK";
        }
        // return results
        return feedbackRow;
    }

    public static boolean hasWon(String[] feedbackRow) {
        return feedbackRow[0] == feedbackRow[1] 
            && feedbackRow[0] == feedbackRow[2] 
            && feedbackRow[0] == feedbackRow[3]
            && feedbackRow[0] == "GREEN";
    }

}