import java.util.Random;

public class Board {
    private final Difficulty difficulty;
    private Colors[] possibleColors = {Colors.RED, Colors.BLUE, Colors.YELLOW, Colors.GREEN, Colors.WHITE, Colors.BLACK, Colors.GREY, Colors.BROWN};
    private Colors[] row = new Colors[4];
    private int numOfRows;
    private int numOfColors;
    private final Colors[] dealerRow;
    private Colors[][] playerRows;

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

    public Colors[] getDealerRow() {
        return dealerRow;
    }

    public Colors[][] getPlayerRows() {
        return playerRows;
    }

    public void setPlayerRows(Colors[][] playerRows) {
        this.playerRows = playerRows;
    }



    public Colors[] getRow() {
        return row;
    }

    private Colors[] generateDealerRow(int numOfColors) {
        // create an array that will hold 4 colors
        Colors[] result = new Colors[4];

        // generate a number between 1 and 4 / 6 / 8 (based on game difficulty)
        Random rand = new Random();
        
        // select a random colour from list of possibleColors and place into each of the 4 slots in result array
        for (int i = 0; i < result.length; i++) {
            int randomNumber = rand.nextInt(numOfColors) + 1;
            result[i] = possibleColors[randomNumber];
        }
        return result;
    }

}