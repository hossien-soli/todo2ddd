package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UsernameAlreadyInUseException extends DomainException {
    public UsernameAlreadyInUseException() {
        super("The username is already in use.");
    }

    @Override
    public String problemKey() {
        return "user.username.in_use";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
