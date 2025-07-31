package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class AccountBannedLoginException extends DomainException {
    public AccountBannedLoginException() {
        super("account was banned and user can't login!");
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
