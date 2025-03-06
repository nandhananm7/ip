import commands.CommandHandler;
import exceptions.TalkoException;
import managers.TaskManager;
import ui.Ui;
import java.util.Scanner;

public class Talko {
    private TaskManager taskManager;
    private CommandHandler commandHandler;
    private Ui ui;

    public Talko() {
        ui = new Ui();
        TaskManager taskManager = new TaskManager();
        commandHandler = new CommandHandler(taskManager);
    }

    public void run() {
        ui.showWelcomeMessage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String input = ui.getUserInput(scanner);
                commandHandler.handleCommand(input);
            } catch (TalkoException e) {
                if ("Exit".equals(e.getMessage())) {
                    break;
                }
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showUnexpectedError(e.getMessage());
            }
            ui.showLine();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        new Talko().run();
    }
}
