package managers;

import exceptions.TalkoException;
import tasks.Task;
import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();
    private int taskCount;

    public TaskManager() {
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        tasks.add(task);
        taskCount++;
        System.out.println("Added: " + task.getDescription());
    }

    public void listTasks() {
        if (taskCount == 0) {
            System.out.println("Yay! You have no tasks :)");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getDescription());
            }
        }
    }

    public void markTask(int index, boolean isDone) throws TalkoException {
        if (index < 0 || index >= taskCount) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            tasks.get(index).mark(isDone);
        }
    }

    public void removeTask(int index) throws TalkoException {
        if (index < 0 || index >= taskCount) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            System.out.println("Removed: " + tasks.get(index).getDescription());
            tasks.remove(index);
            taskCount--;
        }
    }
}
