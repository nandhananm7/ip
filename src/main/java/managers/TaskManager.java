package managers;

import java.util.ArrayList;

import exceptions.TalkoException;
import tasks.Task;
import storage.Storage;

public class TaskManager {
    private ArrayList<Task> tasks;
    private Storage storage;
    int taskCount = 0;

    public TaskManager() {
        this.storage = new Storage();
        this.tasks = storage.load();
    }

    public void addTask(Task task) {
        tasks.add(task);
        taskCount++;
        storage.save(tasks);
        System.out.println("Added: " + task.getDescription());
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Yay! You have no tasks :)");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    public void markTask(int index, boolean isDone) throws TalkoException {
        if (index < 0 || index >= tasks.size()) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            tasks.get(index).mark(isDone);
        }
    }

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

    public void findTasks(String keyword) throws TalkoException {
        if (keyword.isEmpty()) {
            throw new TalkoException("Please provide a keyword to search.");
        }

        // Filter tasks that contain the keyword in their description
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

}
