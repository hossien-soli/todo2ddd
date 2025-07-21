package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UnacceptableClientFullNameException extends DomainException {
    public UnacceptableClientFullNameException() {
        super("The full name is unacceptable. It must be between 5 and 30 characters long.");
    }

    @Override
    public String problemKey() {
        return "user.client_full_name.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
