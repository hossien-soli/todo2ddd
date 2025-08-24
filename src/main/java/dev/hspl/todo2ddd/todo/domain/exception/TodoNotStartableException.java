package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class TodoNotStartableException extends DomainException {
    public TodoNotStartableException() {
        super("todo is not startable!");
    }

    @Override
    public String problemKey() {
        return "todo.status.not_startable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
