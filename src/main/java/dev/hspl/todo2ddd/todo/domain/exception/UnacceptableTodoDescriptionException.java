package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UnacceptableTodoDescriptionException extends DomainException {
    public UnacceptableTodoDescriptionException() {
        super("todo description entered for the todo is unacceptable is must be between 10 and 450 character long");
    }

    @Override
    public String problemKey() {
        return "todo.description.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
