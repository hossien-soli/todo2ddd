package dev.hspl.todo2ddd.user.domain.value;

import dev.hspl.todo2ddd.user.domain.exception.MissingProtectedPasswordException;

// protected = hashed

public record ProtectedPassword(String value) {
    public ProtectedPassword {
        boolean validate = value != null && !value.isEmpty();
        if (!validate) {
            throw new MissingProtectedPasswordException();
        }
    }
}
