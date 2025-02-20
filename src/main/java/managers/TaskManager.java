package managers;

import exceptions.TalkoException;
import tasks.Task;

public class TaskManager {
    private Task[] tasks;
    private int taskCount;

    public TaskManager() {
        this.tasks = new Task[100];
        this.taskCount = 0;
    }

    public void addTask(Task task) {
        if (taskCount < tasks.length) {
            tasks[taskCount] = task;
            taskCount++;
            System.out.println("Added: " + task.getDescription());
        } else {
            System.out.println("talkO has no more room!");
        }
    }

    public void listTasks() {
        if (taskCount == 0) {
            System.out.println("Yay! You have no tasks :)");
        } else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + tasks[i].getDescription());
            }
        }
    }

    public void markTask(int index, boolean isDone) throws TalkoException {
        if (index < 0 || index >= taskCount) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            tasks[index].mark(isDone);
        }
    }

    public void removeTask(int index) throws TalkoException {
        if (index < 0 || index >= taskCount) {
            throw new TalkoException("Please enter a valid task number!");
        } else {
            System.out.println("Removed: " + tasks[index].getDescription());
            //shift elements to avoid blanks and maintain indexing
            for (int i = index; i < taskCount - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[taskCount - 1] = null;
            taskCount--;
        }
    }
}
