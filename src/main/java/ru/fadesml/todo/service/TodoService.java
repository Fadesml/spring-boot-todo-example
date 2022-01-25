package ru.fadesml.todo.service;

import org.springframework.stereotype.Service;
import ru.fadesml.todo.entity.Task;
import ru.fadesml.todo.exceptions.AlreadyExistsException;
import ru.fadesml.todo.exceptions.NotFoundException;
import ru.fadesml.todo.messages.TaskMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TodoService {
    private final List<Task> tasks = new ArrayList<>();

    public Task getById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        throw new NotFoundException(Task.class, Map.of("id", id));
    }

    public List<Task> getAll() {
        if (tasks.isEmpty()) {
            throw new NotFoundException(this.tasks.getClass(), Map.of());
        }

        return List.copyOf(tasks);
    }

    public String addTask(Task task) {
        if (containsById(task.getId())) {
            throw new AlreadyExistsException(Task.class, Map.of("id", task.getId()));
        }

        this.tasks.add(task);

        return TaskMessages.CREATED;
    }

    public String deleteById(Long id) {
        if (containsById(id)) {
            this.tasks.remove(getById(id));

            return TaskMessages.DELETED;
        }

        throw new NotFoundException(Task.class, Map.of("id", id));
    }

    public String deleteAll() {
        this.tasks.clear();

        return TaskMessages.DELETED_ALL;
    }

    private boolean containsById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
