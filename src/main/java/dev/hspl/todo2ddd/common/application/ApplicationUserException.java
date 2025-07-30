package dev.hspl.todo2ddd.common.application;

import dev.hspl.todo2ddd.common.domain.exception.ProblemAware;

// ApplicationUserException means that the exception is thrown when a user attempts to perform an invalid or unauthorized action.
// ApplicationSystemException means that the exception is thrown during internal system operations, without direct user involvement.

public abstract class ApplicationUserException extends RuntimeException implements ProblemAware {
    public ApplicationUserException(String exceptionMessage) { // don't send this message to users
        super(exceptionMessage);
    }
}
