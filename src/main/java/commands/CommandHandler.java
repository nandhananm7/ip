package commands;

import exceptions.TalkoException;
import managers.TaskManager;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

/**
 * Handles user commands and performs appropriate actions based on input.
 * A <code>CommandHandler</code> object processes various commands related to task management.
 */
public class CommandHandler {
    private TaskManager taskManager;

    public CommandHandler(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    /**
     * Processes user input and executes the corresponding command.
     *
     * @param input The command input from the user.
     * @throws TalkoException If an invalid command is given or an error occurs during execution.
     */
    public void handleCommand(String input) throws TalkoException {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : "";

        switch (command) {
        case "bye":
            System.out.println("Bye! Have a great day");
            throw new TalkoException("Exit");
        case "help":
            taskManager.help();
            break;
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
        case "todo":
            if (argument.trim().isEmpty()) throw new TalkoException("Description cannot be empty! Please enter a description of your task!");
            taskManager.addTask(new Todo(argument));
            break;
        case "deadline":
            String[] deadlineDetails = argument.split(" /by ", 2);
            if (deadlineDetails.length < 2) throw new TalkoException("Oops Invalid format :( Try rewriting it to this format: deadline <description> /by <yyyy-mm-dd hhmm>");
            taskManager.addTask(new Deadline(deadlineDetails[0], deadlineDetails[1]));
            break;
        case "event":
            String[] eventDetails = argument.split(" /from | /to ", 3);
            if (eventDetails.length < 3) throw new TalkoException("Oops Invalid format :( Try rewriting it to this format: event <description> /from <yyyy-mm-dd hhmm> /to <yyyy-mm-dd hhmm>");
            taskManager.addTask(new Event(eventDetails[0], eventDetails[1], eventDetails[2]));
            break;
        case "delete":
            int removeIndex = Integer.parseInt(argument) - 1;
            taskManager.removeTask(removeIndex);
            break;
        case "find":
            taskManager.findTasks(argument);
            break;
        default:
            throw new TalkoException("Command not recognized. Please try entering <help> for more information.");
        }
    }
}
