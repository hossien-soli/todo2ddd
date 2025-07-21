package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UnacceptablePlainPasswordException extends DomainException {
    public UnacceptablePlainPasswordException() {
        super("Plain password is unacceptable. It must be at least 8 characters long and must not contain any spaces.");
    }

    @Override
    public String problemKey() {
        return "user.plain_password.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
