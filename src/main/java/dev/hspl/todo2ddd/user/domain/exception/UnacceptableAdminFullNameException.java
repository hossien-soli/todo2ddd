package dev.hspl.todo2ddd.user.domain.exception;

import dev.hspl.todo2ddd.common.domain.exception.DomainException;

public class UnacceptableAdminFullNameException extends DomainException {
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
