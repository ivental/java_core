package ru.mentee.power.methods.taskmanager;

import java.util.*;

public class TaskManager {
    private List<Task> tasks;
    private int nextId = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public Task addTask(String title, String description, Date dueDate, Task.Priority priority) {
        Task task = new Task(nextId, title, description, dueDate, priority);
        tasks.add(task);
        nextId += 1;
        return task;
    }

    public Task addTask(String title) {
        return addTask(title, null, null, null);
    }

    public Task addTask(String title, String description) {
        return addTask(title, description, null, null);
    }

    public Task getTaskById(int id) {
        for (Task i : tasks) {
            if (id == i.getId()) {
                return i;
            }
        }
        return null;
    }

    public boolean removeTask(int id) {
        Task result = getTaskById(id);
        if (result == null) {
            return false;
        }
        tasks.remove(result);
        return true;
    }

    public boolean markTaskAsCompleted(int id) {
        Task result = getTaskById(id);
        if (result == null) {
            return false;
        } else {
            result.markAsCompleted();
        }
        return true;
    }

    public List<Task> getAllTasks() {
        List<Task> taskList = List.copyOf(tasks);
        return taskList;
    }

    public List<Task> getCompletedTasks() {
        List<Task> result = new ArrayList<>();
        for (Task i : tasks) {
            if (i.isCompleted()) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Task> getIncompleteTasks() {
        List<Task> result = new ArrayList<>();
        for (Task i : tasks) {
            if (!i.isCompleted()) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Task> getOverdueTasks() {
        List<Task> result = new ArrayList<>();
        for (Task i : tasks) {
            if (i.isOverdue()) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Task> getTasksByPriority(Task.Priority priority) {
        if (priority == null) throw new IllegalArgumentException();
        List<Task> result = new ArrayList<>();
        for (Task i : tasks) {
            if (i.getPriority() == priority) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Task> searchTasks(String query) {
        if (query == null || query.isEmpty()) throw new IllegalArgumentException();
        List<Task> result = new ArrayList<>();
        for (Task i : tasks) {
            if (i.getTitle() != null && i.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    i.getDescription() != null && i.getDescription().toLowerCase().contains(query.toLowerCase())) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Task> sortTasksByDueDate() {
        List<Task> result = new ArrayList<>(tasks);
        int n = result.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                Date dateFirst = result.get(j).getDueDate();
                Date dateSecond = result.get(j + 1).getDueDate();
                if (dateSecond == null || dateFirst != null && dateFirst.compareTo(dateSecond) > 0) {
                    Task temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return result;
    }

    public List<Task> sortTasksByPriority() {
        List<Task> result = new ArrayList<>(tasks);
        int n = result.size();
        for (int i = 1; i < n; i++) {
            Task temp = result.get(i);
            int j = i - 1;
            while (j >= 0 && ((result.get(j).getPriority() == null)
                    || (result.get(j).getPriority() != null && temp.getPriority() != null
                    && result.get(j).getPriority().compareTo(temp.getPriority()) < 0))) {
                result.set(j + 1, result.get(j));
                j--;
            }
            result.set(j + 1, temp);
        }
        return result;
    }

    public void printAllTasks() {
        printTasks(tasks,"Список всех задач: ");
    }


    public void printTasks(List<Task> taskList, String header) {
        System.out.println(header);
        if (taskList.isEmpty()) {
            System.out.println("Список задач пуст");
            return;
        }
        for (Task i : taskList) {
            System.out.println(i.toString());
        }
    }
}

