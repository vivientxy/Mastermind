import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Board {
    private final Difficulty difficulty;
    private int numOfRows;
    private int numOfColors;
    private List<Colors> possibleColors;
    private final Colors[] dealerRow;
    private Colors[][] playerRows;
    // private Colors[] feedbackRow;

    public Board(Difficulty difficulty) {
        this.difficulty = difficulty;
        switch (difficulty) {
            case EASY:
                this.numOfRows = 8;
                this.numOfColors = 4;
                break;
            case MEDIUM:
                this.numOfRows = 10;
                this.numOfColors = 6;
                break;
            case HARD:
                this.numOfRows = 12;
                this.numOfColors = 8;
                break;
            default:
                break;
        }
        this.possibleColors = generatePossibleColors(numOfColors);
        this.dealerRow = generateDealerRow(numOfColors);
        this.playerRows = new Colors[numOfRows][4];
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfColors() {
        return numOfColors;
    }

    public List<Colors> getPossibleColors() {
        return possibleColors;
    }

    public Colors[] getDealerRow() {
        return dealerRow;
    }

    public Colors[][] getPlayerRows() {
        return playerRows;
    }

    public void setPlayerRows(Colors[][] playerRows) {
        this.playerRows = playerRows;
    }

    // public Colors[] getFeedbackRow() {
    //     return feedbackRow;
    // }

    // public void setFeedbackRow(Colors[] feedbackRow) {
    //     this.feedbackRow = feedbackRow;
    // }

    private Colors[] generateDealerRow(int numOfColors) {
        Colors[] result = new Colors[4];
        List<Colors> possibleColors = generatePossibleColors(numOfColors);
        Random rand = new Random();
        for (int i = 0; i < result.length; i++) {
            int randomNumber = rand.nextInt(numOfColors);
            result[i] = possibleColors.get(randomNumber);
        }
        return result;
    }

    private List<Colors> generatePossibleColors(int numOfColors) {
        List<Colors> result = new ArrayList<>();
        List<Colors> colorList = Arrays.asList(Colors.class.getEnumConstants());
        for (int i = 0; i < numOfColors; i++) {
            result.add(colorList.get(i));
        }
        return result;
    }

    public void printPossibleColors() {
        String result = "";
        for (Colors color : this.possibleColors) {
            result += color + " ";
        }
        System.out.println(result);
    }

}