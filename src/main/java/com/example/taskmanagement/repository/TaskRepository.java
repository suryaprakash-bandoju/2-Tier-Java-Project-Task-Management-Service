package main.java.com.example.taskmanagement.repository;

import com.example.taskmanagement.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    private final AtomicLong idGenerator = new AtomicLong(1);

    public TaskRepository() {

        tasks.add(new Task(
                idGenerator.getAndIncrement(),
                "Learn Java",
                "Practice Java fundamentals",
                false));

        tasks.add(new Task(
                idGenerator.getAndIncrement(),
                "Learn Maven",
                "Practice Maven build lifecycle",
                false));

        tasks.add(new Task(
                idGenerator.getAndIncrement(),
                "Build Web Application",
                "Create a Spring Boot web application",
                true));
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    public Task save(Task task) {

        task.setId(idGenerator.getAndIncrement());

        tasks.add(task);

        return task;
    }

    public void update(Task task) {

        findById(task.getId()).ifPresent(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.isCompleted());
        });
    }

    public boolean deleteById(Long id) {

        return tasks.removeIf(
                task -> task.getId().equals(id));
    }
}