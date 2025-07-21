package dev.hspl.todo2ddd.user.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationException;

public class InvalidUserInfoException extends ApplicationException {
    public InvalidUserInfoException() {
        super("The username and hashed password of the user are not provided correctly.");
    }

    @Override
    public String problemKey() {
        return "user.info.invalid";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
