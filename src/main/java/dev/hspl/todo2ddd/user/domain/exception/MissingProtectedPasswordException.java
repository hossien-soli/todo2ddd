package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class MissingProtectedPasswordException extends DomainException {
    public MissingProtectedPasswordException() {
        super("Protected password not provided.");
    }

    @Override
    public String problemKey() {
        return "user.protected_password.missing";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
