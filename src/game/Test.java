package game;

import game.Game;
import java.util.Scanner;
import java.lang.Exception;


public class Test {


    private static Game gameController = new Game();
    private static Boolean active = true;

    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.
        startCLI();
    }

    public static void startCLI() {
        Scanner scanner = new Scanner(System.in);
        while ( active ) {
            System.out.print("Enter Command: ");
            String cmd = scanner.next();
            try {
                commandCLI(cmd);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void commandCLI(String cmd) {
        switch(cmd) {
            case "start":
                System.out.println("Running Next Command");
                Test.gameController.startGame();
                break;
            case "next":
                System.out.println("Running Next Command");
                // code block for changing teams this step will be ran by the game engine
                break;
            case "roll":
                System.out.println("Running Roll Command");
                // code block for rolling the dice
                break;
            case "exit":
                System.out.println("Exiting Testing CLI");
                Test.active = false;
                break;
            case "help":
                commandHelp();
                break;
            default:
                commandHelp();
          }
    }

    public static void commandHelp() {
        System.out.println("");
        System.out.println("Help Menu");
        System.out.println("> next ");
        System.out.println("> roll");
        System.out.println("> exit");
        System.out.println("> help");
        System.out.println("");
    }

}
