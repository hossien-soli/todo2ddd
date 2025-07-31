package dev.hspl.todo2ddd.user.application.usage.command;

import dev.hspl.todo2ddd.common.application.InvalidApplicationCommandException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.value.PlainPassword;

// all fields are required

public record UserLoginCommand(
        Username username,
        PlainPassword password,
        UserRole roleToLogin
) {
    public UserLoginCommand {
        boolean validate = username != null && password != null && roleToLogin != null;
        if (!validate) {
            throw new InvalidApplicationCommandException("provided user login command is invalid!");
        }
    }
}
