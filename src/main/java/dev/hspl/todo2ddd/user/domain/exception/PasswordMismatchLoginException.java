package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;

public class PasswordMismatchLoginException extends DomainException {
    public PasswordMismatchLoginException(Username username, UserRole roleToLogin) {
        super("password doesn't match for completing the login (%s, %s)".formatted(
                username.value(),
                roleToLogin
        )); // the username and role are metadata for the exception log
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
