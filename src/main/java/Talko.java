import commands.CommandHandler;
import exceptions.TalkoException;
import managers.TaskManager;
import ui.Ui;
import java.util.Scanner;

/**
 * The main class for the Talko application.
 * This class initializes the necessary components and manages the program flow.
 */
public class Talko {
    private TaskManager taskManager;
    private CommandHandler commandHandler;
    private Ui ui;

    public Talko() {
        ui = new Ui();
        TaskManager taskManager = new TaskManager();
        commandHandler = new CommandHandler(taskManager);
    }

    /**
     * Starts the main loop of the Talko application.
     * Continuously takes user input and processes commands until an exit command is received.
     */
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

    /**
     * The entry point of the Talko application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Talko().run();
    }
}
