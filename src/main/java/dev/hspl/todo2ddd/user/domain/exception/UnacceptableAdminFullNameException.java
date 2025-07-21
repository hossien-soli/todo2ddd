package dev.hspl.todo2ddd.user.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationException;

public class UnacceptableAdminFullNameException extends ApplicationException {
    public UnacceptableAdminFullNameException() {
        super("The full name is unacceptable. It must be between 5 and 40 characters long.");
    }

    @Override
    public String problemKey() {
        return "user.admin_full_name.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
