package ui;

import java.util.Scanner;

/**
 * Handles user interaction, including displaying messages and reading input.
 */
public class Ui {
    private static final String SYMBOL = "████████╗ █████╗ ██╗     ██╗  ██╗ ██████╗ \n" +
            "╚══██╔══╝██╔══██╗██║     ██║ ██╔╝██╔═══██╗\n" +
            "   ██║   ███████║██║     █████╔╝ ██║   ██║\n" +
            "   ██║   ██╔══██║██║     ██╔═██╗ ██║   ██║\n" +
            "   ██║   ██║  ██║███████╗██║  ██╗╚██████╔╝\n" +
            "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ";
    private static final String LINE = "----------------------------------------------";

    private final Scanner scanner;

    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcomeMessage() {
        System.out.println("Hello, you can call me");
        System.out.println(SYMBOL);
        System.out.println("How can I help you today?");
        System.out.println(LINE);
    }

    /**
     * Reads user input from the provided scanner.
     *
     * @param scanner The Scanner object to read input from.
     * @return The user input as a string.
     */
    public String getUserInput(Scanner scanner) {
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    /**
     * Displays a general error message.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    /**
     * Displays an unexpected error message.
     *
     * @param message The unexpected error message to display.
     */
    public void showUnexpectedError(String message) {
        System.out.println("Unexpected Error: " + message);
    }

    /**
     * Prints a horizontal line to separate different sections in the UI.
     */
    public void showLine() {
        System.out.println(LINE);
    }
}

