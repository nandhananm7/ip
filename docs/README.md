# Talko User Guide

## Introduction
Talko is a simple task management application that allows users to create and manage tasks via command-line input. This guide will help you understand how to use Talko effectively.

---

## Features and Commands

### 1. List Tasks
**Command:**
```
list
```
**Description:**
Displays all tasks in the task list.

---

### 2. Add a Todo Task
**Command:**
```
todo <description>
```
**Example:**
```
todo Buy groceries
```
**Description:**
Adds a new todo task with the given description.

---

### 3. Add a Deadline Task
**Command:**
```
deadline <description> /by <due date in "yyyy-MM-dd HHmm" format>
```
**Example:**
```
deadline Submit assignment /by 2025-12-03 2100
```
**Description:**
Adds a new task with a deadline.

---

### 4. Add an Event Task
**Command:**
```
event <description> /from <start time in "yyyy-MM-dd HHmm" format> /to <end time in "yyyy-MM-dd HHmm" format>
```
**Example:**
```
event Project meeting /from 2025-12-03 0900 /to 2025-12-03 2100
```
**Description:**
Adds a new event with a start and end time.

---

### 5. Mark a Task as Done
**Command:**
```
mark <task number>
```
**Example:**
```
mark 2
```
**Description:**
Marks the specified task as completed.

---

### 6. Unmark a Task
**Command:**
```
unmark <task number>
```
**Example:**
```
unmark 2
```
**Description:**
Marks the specified task as not completed.

---

### 7. Remove a Task
**Command:**
```
delete <task number>
```
**Example:**
```
delete 3
```
**Description:**
Removes the specified task from the list.

---

### 8. Find a Task by Keyword
**Command:**
```
find <keyword>
```
**Example:**
```
find groceries
```
**Description:**
Searches for tasks that contain the given keyword.

---

### 9. View all commands in Talko
**Command:**
```
help
```
**Description:**
Lists all the commands out with brief description.

---

### 10. Exit the Application
**Command:**
```
bye
```
**Description:**
Exits the Talko application.

---

## Error Handling
- If a command is not recognized, Talko will notify you with an error message.
- If required arguments are missing in a command, Talko will prompt you with the correct format.
- Task indices must be valid numbers corresponding to tasks in the list.

---

## Example Usage
```
> todo Read a book
Added: Read a book

> list
1. [T] Read a book

> mark 1
Nice! I've marked this task as done: [T] [✓] Read a book

> bye
Bye! Have a great day
```

---

Enjoy using Talko to manage your tasks efficiently!

