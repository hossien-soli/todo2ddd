package dev.hspl.todo2ddd.common.application;

public class InvalidApplicationCommandException extends ApplicationUserException {
    public InvalidApplicationCommandException(String message) {
        super(message);
    }

    @Override
    public String problemKey() {
        return "missing_required_data";
    }

    @Override
    public short groupingValue() {
        return 400;
    }
}
