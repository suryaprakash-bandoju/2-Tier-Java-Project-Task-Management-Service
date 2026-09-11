package test.java.com.example.taskmanagement;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {

        TaskRepository repository = new TaskRepository();

        taskService = new TaskService(repository);
    }

    @Test
    void shouldReturnAllTasks() {

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(3, tasks.size());
    }

    @Test
    void shouldCreateTask() {

        Task task = new Task(
                null,
                "Learn Docker",
                "Practice Docker",
                false);

        taskService.createTask(task);

        assertNotNull(task.getId());
        assertEquals(
                "Learn Docker",
                task.getTitle());
    }

    @Test
    void shouldFindTask() {

        Task task = taskService.getTaskById(1L);

        assertEquals(
                "Learn Java",
                task.getTitle());
    }

    @Test
    void shouldUpdateTask() {

        Task updatedTask = new Task(
                null,
                "Learn Advanced Java",
                "Advanced Java concepts",
                true);

        taskService.updateTask(
                1L,
                updatedTask);

        Task result = taskService.getTaskById(1L);

        assertEquals(
                "Learn Advanced Java",
                result.getTitle());

        assertTrue(result.isCompleted());
    }

    @Test
    void shouldDeleteTask() {

        taskService.deleteTask(1L);

        assertThrows(
                RuntimeException.class,
                () -> taskService.getTaskById(1L));
    }
}