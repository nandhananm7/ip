package commands;

import exceptions.TalkoException;
import managers.TaskManager;
import tasks.Deadline;
import tasks.Event;
import tasks.Todo;

public class CommandHandler {
    private TaskManager taskManager;

    public CommandHandler(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    //handles user command and performs appropriate action
    public void handleCommand(String input) throws TalkoException {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1].trim() : "";

        switch (command) {
        case "bye":
            System.out.println("Bye! Have a great day");
            throw new TalkoException("Exit");
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
            if (deadlineDetails.length < 2) throw new TalkoException("Oops Invalid format :( Try rewriting it to this format: deadline <description> /by <due date>");
            taskManager.addTask(new Deadline(deadlineDetails[0], deadlineDetails[1]));
            break;
        case "event":
            String[] eventDetails = argument.split(" /from | /to ", 3);
            if (eventDetails.length < 3) throw new TalkoException("Oops Invalid format :( Try rewriting it to this format: event <description> /from <start> /to <end>");
            taskManager.addTask(new Event(eventDetails[0], eventDetails[1], eventDetails[2]));
            break;
        case "remove":
            int removeIndex = Integer.parseInt(argument) - 1;
            taskManager.removeTask(removeIndex);
            break;
        default:
            throw new TalkoException("Command not recognized. Please try using any of the following commands: bye, list, mark, unmark, todo, event, deadline");
        }
    }
}
