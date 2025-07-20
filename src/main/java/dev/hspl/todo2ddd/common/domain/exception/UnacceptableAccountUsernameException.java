package dev.hspl.todo2ddd.common.domain.exception;

public class UnacceptableAccountUsernameException extends DomainException {
    public UnacceptableAccountUsernameException() {
        super("Username is unacceptable. It must be between 5 and 30 characters long and can only contain English letters, numbers, underscores, and hyphens.");
    }

    @Override
    public String problemKey() {
        return "common.username.unacceptable";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
