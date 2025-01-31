import java.util.Scanner;

public class Talko {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = "talkO";
        String symbol = "████████╗ █████╗ ██╗     ██╗  ██╗ ██████╗ \n" +
                "╚══██╔══╝██╔══██╗██║     ██║ ██╔╝██╔═══██╗\n" +
                "   ██║   ███████║██║     █████╔╝ ██║   ██║\n" +
                "   ██║   ██╔══██║██║     ██╔═██╗ ██║   ██║\n" +
                "   ██║   ██║  ██║███████╗██║  ██╗╚██████╔╝\n" +
                "   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ";
        String line = "----------------------------------------------";
        System.out.println("Hello you can call me");
        System.out.println(symbol);
        System.out.println("How can I help you today?");
        System.out.println(line);
        String input = in.nextLine();

        while(!input.equalsIgnoreCase("bye")) {
            System.out.println(input);
            System.out.println(line);
            input = in.nextLine();
        }
        System.out.println("Bye! Have a great day");
    }
}
