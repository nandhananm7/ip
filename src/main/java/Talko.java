import java.util.Scanner;

public class Talko {
    public class Task {
        protected String description;
        protected boolean isDone;

        //constructor
        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public void mark(int index, int isDone) {
            if (isDone == 1) {
                this.isDone = true;
                System.out.println("Marked as Done!");
            } else {
                this.isDone = false;
                System.out.println("Marked as Not Done!");
            }
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " ");
        }
    }

    private Task[] tasks;
    private int taskCount;

    public Talko() {
        this.tasks = new Task[100];
        this.taskCount = 0;
    }

    public void addTask(String description) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = new Task(description);
            taskCount++;
        } else {
            System.out.println("talkO has no more room!");
        }
    }

    public void listTasks() {
        if (taskCount == 0) {
            System.out.println("Yay! You have no tasks :)");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + "[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
            }
        }
    }

    private void markTask(int index, int i) {
        if (index >= 0 && index < taskCount) {
            tasks[index].mark(index, i);
        } else {
            System.out.println("Please enter a valid task number!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = "talkO";
        String symbol = "+-+-+-+-+-+\n" + "|t|a|l|k|O|\n" + "+-+-+-+-+-+";
        String line = "----------------------------------------------";

        Talko talko = new Talko();

        System.out.println("Hello you can call me");
        System.out.println(symbol);
        System.out.println("How can I help you today?");
        System.out.println(line);

        while (true) {
            String input = in.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println("Bye! Have a great day");
                break;
            } else if (input.equalsIgnoreCase("list")) {
                talko.listTasks();
            } else if (input.startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5).trim()) - 1;
                talko.markTask(index, 1);
            } else if (input.startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7).trim()) - 1;
                talko.markTask(index, 0);
            } else {
                talko.addTask(input);
                System.out.println("Added: " + input);
            }
            System.out.println(line);
        }
    }
}
