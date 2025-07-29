package dev.hspl.todo2ddd.user.application.usage.command;

import dev.hspl.todo2ddd.common.application.InvalidApplicationCommandException;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.value.PlainPassword;

// all fields are required

public record ClientRegistrationCommand(
        String fullName,
        Username username,
        PlainPassword password,
        PlainPassword passwordConfirmation
) {
    public ClientRegistrationCommand {
        boolean validate = fullName != null && username != null && password != null && passwordConfirmation != null;
        if (!validate) {
            throw new InvalidApplicationCommandException("Provided client registration command is invalid!");
        }
    }
}
