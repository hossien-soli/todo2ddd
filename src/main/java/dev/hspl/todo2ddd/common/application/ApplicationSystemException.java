package dev.hspl.todo2ddd.common.application;

// ApplicationUserException means that the exception is thrown when a user attempts to perform an invalid or unauthorized action.
// ApplicationSystemException means that the exception is thrown during internal system operations, without direct user involvement.

public abstract class ApplicationSystemException extends RuntimeException {
    public ApplicationSystemException(String message) {
        super(message);
    }
}
