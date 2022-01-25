package ru.fadesml.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(Class<?> clazz, Map<String, Object> data) {
        super("Not found + " + clazz.getName() + " with data: " + data.toString());
    }
}
