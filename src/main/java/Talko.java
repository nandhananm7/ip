import java.util.Scanner;

public class Talko {
    public static void main(String[] args) throws TalkoException {
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        CommandHandler commandHandler = new CommandHandler(taskManager);

        String symbol = "+-+-+-+-+-+\n" + "|t|a|l|k|O|\n" + "+-+-+-+-+-+";
        String line = "----------------------------------------------";

        System.out.println("Hello, you can call me");
        System.out.println(symbol);
        System.out.println("How can I help you today?");
        System.out.println(line);

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

            System.out.println(line);
        }
        in.close();
    }
}