package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class PasswordConfirmationFailedException extends DomainException {
    public PasswordConfirmationFailedException() {
        super("Actual password doesn't match it's confirmation!");
    }

    @Override
    public String problemKey() {
        return "user.password_confirmation.failed";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
