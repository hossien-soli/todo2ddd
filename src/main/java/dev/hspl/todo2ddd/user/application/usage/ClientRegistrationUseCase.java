package dev.hspl.todo2ddd.user.application.usage;

import dev.hspl.todo2ddd.user.application.usage.command.ClientRegistrationCommand;

public interface ClientRegistrationUseCase {
    void execute(ClientRegistrationCommand command);
}
