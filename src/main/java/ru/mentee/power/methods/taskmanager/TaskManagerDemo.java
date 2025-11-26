package ru.mentee.power.methods.taskmanager;
import java.util.Calendar;
import java.util.Date;

public class TaskManagerDemo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Сдать отчет", "Годовой отчет по проекту",
                createDate(2025, 10, 26), Task.Priority.HIGH);
        taskManager.addTask("Совещание с командой", null,
                createDate(2025, 11, 26), Task.Priority.MEDIUM);
        taskManager.addTask("Планирование отпуска", "Выбрать даты и отель",
                createDate(2026, 4, 1), Task.Priority.LOW);
        taskManager.addTask("Изучить Spring", "Новый фреймворк");
        Task completedTask = taskManager.addTask("Выполнить задачу MP-43", "Рекурсия в JAVA");
        taskManager.markTaskAsCompleted(completedTask.getId());

        System.out.println("---Начальное состояние---");
        taskManager.printAllTasks();
        System.out.println("---Поиск задач---");
        System.out.println();

        System.out.println("Поиск задачи по заданному слову `отпуск` : " + taskManager.searchTasks("отпуск"));
        System.out.println();

        System.out.println("---Сортировка задач---");
        taskManager.printTasks(taskManager.sortTasksByPriority(), " Сортировка по приоритету: ");
        taskManager.printTasks(taskManager.sortTasksByDueDate(), " Сортировка по дате: ");
        System.out.println();

        System.out.println("---Фильтрация---");
        taskManager.printTasks(taskManager.getCompletedTasks(), " Выполненные: ");
        taskManager.printTasks(taskManager.getIncompleteTasks(), " Невыполненные: ");
        System.out.println("Задача выполнена: " + taskManager.markTaskAsCompleted(1));
        System.out.println();

        System.out.println("---Текущее состояние---");
        taskManager.printAllTasks();
    }

    private static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}


