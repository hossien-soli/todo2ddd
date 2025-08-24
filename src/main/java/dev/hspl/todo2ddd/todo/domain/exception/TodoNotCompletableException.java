package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class TodoNotCompletableException extends DomainException {
    public TodoNotCompletableException() {
        super("todo not completable exception");
    }

    @Override
    public String problemKey() {
        return "todo.status.not_completable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
