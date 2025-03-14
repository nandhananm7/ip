package managers;

import java.util.ArrayList;

import exceptions.TalkoException;
import tasks.Task;
import storage.Storage;

/**
 * Manages a list of tasks, allowing addition, removal, modification, and retrieval of tasks.
 */
public class TaskManager {
    private ArrayList<Task> tasks;
    private Storage storage;
    int taskCount = 0;

    public TaskManager() {
        this.storage = new Storage();
        this.tasks = storage.load();
    }

    /**
     * Adds a new task to the list and saves it to storage.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
        taskCount++;
        storage.save(tasks);
        System.out.println("Added: " + task.getDescription());
    }

    /**
     * Displays all tasks currently stored in the list.
     * If no tasks exist, it notifies the user.
     */
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Yay! You have no tasks :)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    /**
     * Marks a task based on its index and isDone value.
     *
     * @param index The index of the task to be marked as completed.
     * @param isDone The true sets task to done and false sets task to not done.
     * @throws IllegalArgumentException If the index is out of bounds.
     */
    public void markTask(int index, boolean isDone) throws TalkoException {
        if (index < 0 || index >= tasks.size()) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            tasks.get(index).mark(isDone);
        }
    }

    /**
     * Removes a task from the task list and saves the updated list to storage.
     *
     * @param index The index of the task to be removed.
     * @throws IllegalArgumentException If the task number is invalid.
     */
    public void removeTask(int index) throws TalkoException {
        if (index < 0 || index >= tasks.size()) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            System.out.println("Removed: " + tasks.get(index).getDescription());
            tasks.remove(index);
            taskCount--;
            storage.save(tasks);
        }
    }

    /**
     * Searches for tasks that contain the specified keyword in their description.
     *
     * @param keyword The keyword to search for within task descriptions.
     * @throws IllegalArgumentException If the keyword is empty.
     */
    public void findTasks(String keyword) throws TalkoException {
        if (keyword.isEmpty()) {
            throw new TalkoException("Please provide a keyword to search.");
        }

        boolean found = false;
        System.out.println("Here are the matching tasks in your list:");

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                found = true;
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }

        if (!found) {
            throw new TalkoException("No tasks found with the keyword: " + keyword);
        }
    }

    /**
     * Displays the list of available commands and their descriptions.
     */
    public void help() {
        System.out.println("Here are the available commands:");
        System.out.println("1. list");
        System.out.println("    - Displays all tasks in your task list.");
        System.out.println("2. mark <task_number>");
        System.out.println("    - Marks the specified task as done.");
        System.out.println("3. unmark <task_number>");
        System.out.println("    - Marks the specified task as not done.");
        System.out.println("4. todo <task_description>");
        System.out.println("    - Adds a new to-do task.");
        System.out.println("5. deadline <task_description> /by <due_date>   ");
        System.out.println("    - Adds a new task with a deadline.");
        System.out.println("    - Format of the due date is yyyy-MM-dd HHmm (in 24 hr clock)");
        System.out.println("6. event <task_description> /from <event_time>  /to <event_time>");
        System.out.println("    - Adds a new task as an event");
        System.out.println("    - Format of the from and to times is yyyy-MM-dd HHmm (in 24 hr clock)");
        System.out.println("7. delete <task_number>");
        System.out.println("    - Removes the specified task from the list.");
        System.out.println("8. find <keyword>");
        System.out.println("    - Searches for tasks that contain the specified keyword.");
        System.out.println("9. help");
        System.out.println("    - Shows a list of available commands.");
        System.out.println("10. bye");
        System.out.println("    - Exits the program.");
    }

}
