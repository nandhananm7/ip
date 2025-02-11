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

    public void markTask(int index, boolean isDone) {
        if (index >= 0 && index < taskCount) {
            tasks[index].mark(isDone);
        } else {
            System.out.println("Please enter a valid task number!");
        }
    }
}
