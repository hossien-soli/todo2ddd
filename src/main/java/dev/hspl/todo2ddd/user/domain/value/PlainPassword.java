package dev.hspl.todo2ddd.user.application.value;

import dev.hspl.todo2ddd.user.application.exception.UnacceptablePlainPasswordException;

public record PlainPassword(String value) {
    public PlainPassword {
        boolean validate = value != null && value.length() >= 8 &&
                value.length() <= 70 && !value.contains(" ");
        if (!validate) {
            throw new UnacceptablePlainPasswordException();
        }
    }
}

