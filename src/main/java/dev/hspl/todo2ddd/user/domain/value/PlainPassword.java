package dev.hspl.todo2ddd.user.domain.value;

import dev.hspl.todo2ddd.user.domain.exception.UnacceptablePlainPasswordException;

public record PlainPassword(String value) {
    public PlainPassword {
        boolean validate = value != null && value.length() >= 8 &&
                value.length() <= 70 && !value.contains(" ");
        if (!validate) {
            throw new UnacceptablePlainPasswordException();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}

