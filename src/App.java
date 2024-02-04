import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {

        Console console = System.console();

        System.out.println(
            "Welcome to a game of Mastermind!\n\n" +
            "Please choose your difficulty level:");
        Difficulty.printDifficultyList();
        
        String choice = console.readLine("Selection: ");

        
    }
}
