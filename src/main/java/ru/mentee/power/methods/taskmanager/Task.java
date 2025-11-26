package ru.mentee.power.methods.taskmanager;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date dueDate;
    private Priority priority;
    private boolean completed;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Task(int id, String title, String description, Date dueDate, Priority priority, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = completed;
    }

    public Task(int id, String title, String description, Date dueDate, Priority priority) {
        this(id, title, description, dueDate, priority, false);
    }

    public Task(int id, String title) {
        this(id, title, null, null, null, false);
    }

    public Task(int id, String title, String description) {
        this(id, title, description, null, null, false);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    public boolean isOverdue() {
        if (dueDate == null) {
            return false;
        }
        Date date = new Date();
        if (dueDate.before(date)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(this.id + " ");
        result.append(this.title + " - ");
        if (completed == true) {
            result.append("Задача выполнена - ");
        } else {
            result.append("Задача не выполнена - ");
        }
        if (priority == null) {
            result.append("Приоритет не указан - ");
        } else {
            result.append(priority.name() + " - ");
        }
        if (dueDate == null) {
            result.append("Срок не указан - ");
        } else {
            result.append(dueDate);
        }
        return result.toString();
    }
}
