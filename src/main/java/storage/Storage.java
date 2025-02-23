package storage;

import tasks.Task;
import tasks.Todo;
import tasks.Deadline;
import tasks.Event;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private final String filePath;

    public Storage() {
        this.filePath = "./src/main/java/storage/Data.txt";
    }

    public ArrayList<Task> load() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ", -1);

                if (parts.length < 3) { // Minimum required parts check
                    System.out.println("Skipping invalid line: " + line);
                    continue;
                }

                Task task;
                switch (parts[0]) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    if (parts.length < 4) {
                        System.out.println("Skipping invalid Deadline task: " + line);
                        continue;
                    }
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    if (parts.length < 5) {
                        System.out.println("Skipping invalid Event task: " + line);
                        continue;
                    }
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    System.out.println("Skipping unknown task type: " + parts[0]);
                    continue;
                }

                if (parts[1].equals("1")) {
                    task.mark(true);
                }

                tasks.add(task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting with an empty task list.");
        }

        return tasks;
    }

    public void save(ArrayList<Task> tasks) {
        File file = new File(filePath);

        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs(); // Ensure parent directories exist
            }

            if (!file.exists()) {
                file.createNewFile(); //creates new file
            }

            // Overwrite the file instead of appending
            FileWriter fw = new FileWriter(file, false);

            for (Task task : tasks) {
                fw.write(task.toFileFormat() + "\n");
            }

            fw.close();
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
