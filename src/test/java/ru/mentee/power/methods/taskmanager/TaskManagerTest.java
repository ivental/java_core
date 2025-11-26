package ru.mentee.power.methods.taskmanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TaskManagerTest {
    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();

        taskManager.addTask("Срочная задача", "Выполнить скорее",
                createDate(2023, 5, 15), Task.Priority.HIGH);
        taskManager.addTask("Обычная задача", "В течение недели",
                createDate(2023, 6, 1), Task.Priority.MEDIUM);
        taskManager.addTask("Несрочная задача", "Когда будет время",
                createDate(2023, 7, 1), Task.Priority.LOW);
        taskManager.addTask("Задача без описания");
    }

    @Test
    void testAddTask() {

        Task task = taskManager.addTask("Срочная задача", "Выполнить скорее", createDate(2023, 5, 15),
                Task.Priority.HIGH);
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("Срочная задача");
        assertThat(task.getDescription()).isEqualTo("Выполнить скорее");
        assertThat(task.getPriority()).isEqualTo(Task.Priority.HIGH);
        assertThat(task.isCompleted()).isFalse();
        assertThat(taskManager.getAllTasks()).contains(task);

    }

    @Test
    void testGetTaskById() {
        Task task = taskManager.getTaskById(2);
        assertThat(task).isNotNull();
        assertThat(task.getTitle()).isEqualTo("Обычная задача");
        Task notFoundTask = taskManager.getTaskById(777);
        assertThat(notFoundTask).isNull();
        Task negativeIdTask = taskManager.getTaskById(-5);
        assertThat(negativeIdTask).isNull();
        Task zeroIdTask = taskManager.getTaskById(0);
        assertThat(zeroIdTask).isNull();
    }

    @Test
    void testGetTasksByPriority() {
        assertThat(taskManager.getTasksByPriority(Task.Priority.LOW)).hasSize(1)
                .extracting(Task::getTitle).contains("Несрочная задача");
        assertThat(taskManager.getTasksByPriority(Task.Priority.MEDIUM)).hasSize(1)
                .extracting(Task::getTitle).contains("Обычная задача");
        assertThat(taskManager.getTasksByPriority(Task.Priority.HIGH)).hasSize(1)
                .extracting(Task::getTitle).contains("Срочная задача");
        assertThatThrownBy(() -> taskManager.getTasksByPriority(null));
    }

    @Test
    void testSearchTasks() {
        assertThat(taskManager.searchTasks("Срочн")).hasSize(2).extracting(Task::getTitle).
                contains("Срочная задача");
        assertThat(taskManager.searchTasks("СрОчН")).hasSize(2).extracting(Task::getTitle).
                contains("Срочная задача");
        assertThat(taskManager.searchTasks("задача")).hasSize(4).extracting(Task::getTitle).
                contains("Срочная задача");
        assertThat(taskManager.searchTasks("скорее")).hasSize(1).extracting(Task::getTitle).
                contains("Срочная задача");
        assertThat(taskManager.searchTasks("отпуск")).isEmpty();
        assertThatThrownBy(() -> taskManager.searchTasks(null));
        assertThatThrownBy(() -> taskManager.searchTasks(""));
    }

    @Test
    void testSortTasksByPriority() {
        assertThat(taskManager.sortTasksByPriority()).extracting(Task::getPriority).
                containsExactly(Task.Priority.HIGH, Task.Priority.MEDIUM, Task.Priority.LOW,null);
        assertThat(taskManager.sortTasksByPriority()).extracting(Task::getTitle).
                containsExactly("Срочная задача", "Обычная задача", "Несрочная задача","Задача без описания");
    }

    private static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}
