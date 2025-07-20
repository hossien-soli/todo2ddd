package dev.hspl.todo2ddd.common.application;

import dev.hspl.todo2ddd.common.domain.exception.ProblemAware;

public abstract class ApplicationException extends RuntimeException implements ProblemAware {
    public ApplicationException(String exceptionMessage) { // don't send this message to users
        super(exceptionMessage);
    }
}
