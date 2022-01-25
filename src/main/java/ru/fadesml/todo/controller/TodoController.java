package ru.fadesml.todo.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fadesml.todo.entity.Task;
import ru.fadesml.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return todoService.getById(id);
    }

    @GetMapping
    public List<Task> getAll() {
        return todoService.getAll();
    }

    @PostMapping
    public String addTask(@RequestBody Task task) {
        return todoService.addTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        return todoService.deleteById(id);
    }

    @DeleteMapping
    public String deleteAll() {
        return todoService.deleteAll();
    }
}
