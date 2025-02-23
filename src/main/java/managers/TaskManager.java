package managers;

import java.util.ArrayList;

import exceptions.TalkoException;
import tasks.Task;
import java.util.ArrayList;
import storage.Storage;

public class TaskManager {
<<<<<<< HEAD
    private ArrayList<Task> tasks;
    private Storage storage;

    public TaskManager() {
<<<<<<< HEAD
        this.tasks = new ArrayList<>();
=======
    ArrayList<Task> tasks = new ArrayList<>();
    private int taskCount;

    public TaskManager() {
        this.taskCount = 0;
>>>>>>> branch-level-6
=======
        this.storage = new Storage();
        this.tasks = storage.load();
>>>>>>> branch-level-7
    }

    public void addTask(Task task) {
        tasks.add(task);
<<<<<<< HEAD
<<<<<<< HEAD
=======
        taskCount++;
>>>>>>> branch-level-6
=======
        storage.save(tasks);
>>>>>>> branch-level-7
        System.out.println("Added: " + task.getDescription());
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Yay! You have no tasks :)");
        } else {
<<<<<<< HEAD
            for (int i = 0; i < tasks.size(); i++) {
=======
            for (int i = 0; i < taskCount; i++) {
>>>>>>> branch-level-6
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    public void markTask(int index, boolean isDone) throws TalkoException {
        if (index < 0 || index >= tasks.size()) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            tasks.get(index).mark(isDone);
<<<<<<< HEAD
<<<<<<< HEAD
=======
        }
    }

    public void removeTask(int index) throws TalkoException {
        if (index < 0 || index >= taskCount) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            System.out.println("Removed: " + tasks.get(index).getDescription());
            tasks.remove(index);
            taskCount--;
>>>>>>> branch-level-6
=======
            storage.save(tasks);
>>>>>>> branch-level-7
        }
    }
}
