package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class RoleMismatchLoginException extends DomainException {
    public RoleMismatchLoginException() {
        super("the requested user role to login doesn't match the provided user's role");
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
