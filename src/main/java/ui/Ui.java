package ui;

import java.util.Scanner;

public class Ui {
    private static final String SYMBOL = "████████╗ █████╗ ██╗     ██╗  ██╗ ██████╗ \n" +
            "╚══██╔══╝██╔══██╗██║     ██║ ██╔╝██╔═══██╗\n" +
            "   ██║   ███████║██║     █████╔╝ ██║   ██║\n" +
            "   ██║   ██╔══██║██║     ██╔═██╗ ██║   ██║\n" +
            "   ██║   ██║  ██║███████╗██║  ██╗╚██████╔╝\n" +
            "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ";
    private static final String LINE = "----------------------------------------------";

    private final Scanner scanner;

    //initializes the scanner
    public Ui() {
        scanner = new Scanner(System.in);
    }

    //shows the welcome message
    public void showWelcomeMessage() {
        System.out.println("Hello, you can call me");
        System.out.println(SYMBOL);
        System.out.println("How can I help you today?");
        System.out.println(LINE);
    }

    public String getUserInput(Scanner scanner) {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    //prints error messages
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showUnexpectedError(String message) {
        System.out.println("Unexpected Error: " + message);
    }

    public void showLine() {
        System.out.println(LINE);
    }
}

