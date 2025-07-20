package dev.hspl.todo2ddd.common.domain.exception;

// This interface creates a reference to a user-friendly error message.

public interface ProblemAware {
    String problemKey(); // a message key for the user (user-friendly message)

    short groupingValue(); // always enter related http status code for simplicity to exception handling
}
