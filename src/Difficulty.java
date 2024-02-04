import java.util.Arrays;

public enum Difficulty {
    EASY, MEDIUM, HARD;

    public static void printDifficultyList() {
        Arrays.asList(Difficulty.values()).stream().forEach(difficulty -> System.out.println("- " + difficulty));
    }

    public static boolean isEnumValue(String input) {

        Arrays.asList(Difficulty.values()).stream().filter(difficulty -> difficulty.equals(input));


        
        return false;
    }
}