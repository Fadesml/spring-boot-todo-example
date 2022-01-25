package ru.fadesml.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(Class<?> clazz, Map<String, Object> data) {
        super("Already exists + " + clazz.getName() + " with data: " + data.toString());
    }
}
