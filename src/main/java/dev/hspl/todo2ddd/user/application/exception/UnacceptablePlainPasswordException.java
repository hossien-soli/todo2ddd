package dev.hspl.todo2ddd.user.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationException;

public class UnacceptablePlainPasswordException extends ApplicationException {
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
