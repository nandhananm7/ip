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
deadline <description> /by <due date>
```
**Example:**
```
deadline Submit assignment /by Monday
```
**Description:**
Adds a new task with a deadline.

---

### 4. Add an Event Task
**Command:**
```
event <description> /from <start time> /to <end time>
```
**Example:**
```
event Project meeting /from 2pm /to 4pm
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
remove <task number>
```
**Example:**
```
remove 3
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

### 9. Exit the Application
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

## Notes
- Tasks are stored persistently using a storage system.
- Use correct formatting for commands to avoid errors.

Enjoy using Talko to manage your tasks efficiently!

