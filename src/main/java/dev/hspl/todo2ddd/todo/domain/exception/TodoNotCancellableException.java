package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class TodoNotCancellableException extends DomainException {
    public TodoNotCancellableException() {
        super("todo is not cancellable");
    }

    @Override
    public String problemKey() {
        return "todo.status.not_cancellable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
