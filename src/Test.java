import game.Game;

import java.util.Scanner;


public class Test {


    private static Game gameController;
    private static Boolean active = true;

    public static void main(String[] args) {
        if (args.length >= 1 && args[0].equals("a")) {
            autoTest();
        } else {
            startCLI();
        }
        
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
        scanner.close();
    }

    public static void commandCLI(String cmd) {
        switch(cmd) {
            case "start":
                System.out.println("Running Start Command");
                Test.gameController = new Game();
//                Test.gameController.startGame();
                break;
            case "next":
                System.out.println("Running Next Command");
                Test.gameController.nextTeam();
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
    public static void autoTest() {
        commandCLI("start");
        commandCLI("roll");
        commandCLI("next");
        commandCLI("roll");
        commandCLI("next");
        commandCLI("roll");
        commandCLI("exit");
    }

    public static void commandHelp() {
        System.out.println();
        System.out.println("Help Menu");
        System.out.println("> start");
        System.out.println("> next");
        System.out.println("> roll");
        System.out.println("> exit");
        System.out.println("> help");
        System.out.println();
    }

}
