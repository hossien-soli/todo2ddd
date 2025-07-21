package dev.hspl.todo2ddd.user.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationException;

public class UnacceptableClientFullNameException extends ApplicationException {
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
