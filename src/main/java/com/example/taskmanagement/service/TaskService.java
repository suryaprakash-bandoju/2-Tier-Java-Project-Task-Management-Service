package main.java.com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Long id, Task task) {

        Task existingTask = getTaskById(id);

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.isCompleted());

        taskRepository.update(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}