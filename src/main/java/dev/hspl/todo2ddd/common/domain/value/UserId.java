package dev.hspl.todo2ddd.common.domain.value;

import dev.hspl.todo2ddd.common.domain.exception.MissingUserIdException;

import java.util.UUID;

public record UserId(UUID value) {
    public UserId {
        if (value == null) {
            throw new MissingUserIdException();
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
