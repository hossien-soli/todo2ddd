package dev.hspl.todo2ddd.todo.domain.value;

import dev.hspl.todo2ddd.todo.domain.exception.UnacceptableTodoDescriptionException;

public record TodoDescription(String value) {
    public TodoDescription {
        boolean validate = value != null && value.length() >= 10 && value.length() <= 450;
        if (!validate) {
            throw new UnacceptableTodoDescriptionException();
        }
    }
}
