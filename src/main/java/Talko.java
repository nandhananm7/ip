import java.util.Scanner;

public class Talko {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        String symbol = "+-+-+-+-+-+\n" + "|t|a|l|k|O|\n" + "+-+-+-+-+-+";
        String line = "----------------------------------------------";

        System.out.println("Hello, you can call me");
        System.out.println(symbol);
        System.out.println("How can I help you today?");
        System.out.println(line);

        while (true) {
            String input = in.nextLine().trim();
            String command = input.split(" ", 2)[0];
            String argument = input.contains(" ") ? input.substring(input.indexOf(" ") + 1).trim() : "";

            switch (command.toLowerCase()) {
            case "bye":
                System.out.println("Bye! Have a great day");
                in.close();
                return;
            case "list":
                taskManager.listTasks();
                break;
            case "mark":
                int markIndex = Integer.parseInt(argument) - 1;
                taskManager.markTask(markIndex, true);
                break;
            case "unmark":
                int unmarkIndex = Integer.parseInt(argument) - 1;
                taskManager.markTask(unmarkIndex, false);
                break;
            default:
                taskManager.addTask(input);
            }
            System.out.println(line);
        }
    }
}