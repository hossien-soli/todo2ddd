package dev.hspl.todo2ddd.user.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationUserException;

public class UserNotFoundLoginException extends ApplicationUserException {
    public UserNotFoundLoginException() {
        super("no user found for proceeding the login based on provided credentials");
    }

    @Override
    public String problemKey() {
        return "user.login.invalid_credentials";
    }

    @Override
    public short groupingValue() {
        return 401;
    }
}
