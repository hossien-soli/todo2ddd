package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class TodoNotDeferrableException extends DomainException {
    public TodoNotDeferrableException() {
        super("todo not deferrable!");
    }

    @Override
    public String problemKey() {
        return "todo.status.not_deferrable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
