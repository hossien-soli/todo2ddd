package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class InvalidTodoInfoException extends DomainException {
    public InvalidTodoInfoException() {
        super("the expected information for todo was not found");
    }

    @Override
    public String problemKey() {
        return "todo.info.invalid";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
