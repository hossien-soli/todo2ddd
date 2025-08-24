package dev.hspl.todo2ddd.todo.domain.value;

import dev.hspl.todo2ddd.todo.domain.exception.UnacceptableTodoTitleException;

public record TodoTitle(String value) {
    public TodoTitle {
        boolean validate = value != null && value.length() >= 5 && value.length() <= 50;
        if (!validate) {
            throw new UnacceptableTodoTitleException();
        }
    }
}
