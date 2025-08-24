package dev.hspl.todo2ddd.todo.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UnacceptableTodoTitleException extends DomainException {
    public UnacceptableTodoTitleException() {
        super("todo title entered for the todo is unacceptable is must be between 5 and 50 character long");
    }

    @Override
    public String problemKey() {
        return "todo.title.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
