package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute(
                "tasks",
                taskService.getAllTasks());

        return "index";
    }

    @GetMapping("/tasks/new")
    public String showCreateForm(Model model) {

        model.addAttribute(
                "task",
                new Task());

        return "task-form";
    }

    @PostMapping("/tasks")
    public String createTask(@ModelAttribute Task task) {

        taskService.createTask(task);

        return "redirect:/";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showEditForm(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "task",
                taskService.getTaskById(id));

        return "task-form";
    }

    @PostMapping("/tasks/update/{id}")
    public String updateTask(
            @PathVariable Long id,
            @ModelAttribute Task task) {

        taskService.updateTask(id, task);

        return "redirect:/";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(
            @PathVariable Long id) {

        taskService.deleteTask(id);

        return "redirect:/";
    }
}