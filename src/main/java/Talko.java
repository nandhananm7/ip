import java.util.Scanner;

import commands.CommandHandler;
import exceptions.TalkoException;
import managers.TaskManager;

public class Talko {
    private static final String SYMBOL = "████████╗ █████╗ ██╗     ██╗  ██╗ ██████╗ \n" +
            "╚══██╔══╝██╔══██╗██║     ██║ ██╔╝██╔═══██╗\n" +
            "   ██║   ███████║██║     █████╔╝ ██║   ██║\n" +
            "   ██║   ██╔══██║██║     ██╔═██╗ ██║   ██║\n" +
            "   ██║   ██║  ██║███████╗██║  ██╗╚██████╔╝\n" +
            "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ";
    private static final String LINE = "----------------------------------------------";

    public static void main(String[] args) throws TalkoException {
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        CommandHandler commandHandler = new CommandHandler(taskManager);

        System.out.println("Hello, you can call me");
        System.out.println(SYMBOL);
        System.out.println("How can I help you today?");
        System.out.println(LINE);

        while (true) {
            try {
                System.out.print("> ");
                String input = in.nextLine().trim();

                if (input.equalsIgnoreCase("bye")) {
                    break;
                }
                commandHandler.handleCommand(input);
            } catch (TalkoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
            }

            System.out.println(LINE);
        }
        in.close();
    }
}