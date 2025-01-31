import java.util.Scanner;

public class Talko {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = "talkO";
        String symbol = "+-+-+-+-+-+\n" +
                "|t|a|l|k|O|\n" +
                "+-+-+-+-+-+";
        String line = "----------------------------------------------";
        String[] tasks = new String[100];
        int taskCount = 0;

        System.out.println("Hello you can call me");
        System.out.println(symbol);
        System.out.println("How can I help you today?");
        System.out.println(line);
        String input = in.nextLine();

        while (!input.equalsIgnoreCase("bye")) {
            if (input.equalsIgnoreCase("list")) {
                if (taskCount == 0) {
                    System.out.println("Yay! You have no tasks :)");
                } else {
                    for (int i = 0; i < taskCount; i++) {
                        System.out.println(i+1 + ". " + tasks[i]);
                    }
                }
            } else if (taskCount < tasks.length) {
                tasks[taskCount] = input;
                taskCount++;
                System.out.println("added: " + input);
            } else {
                System.out.println("talkO has no more room!");
            }
            System.out.println(line);
            input = in.nextLine();
        }
        System.out.println("Bye! Have a great day");
    }
}
