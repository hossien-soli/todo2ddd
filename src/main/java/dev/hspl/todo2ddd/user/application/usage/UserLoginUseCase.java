package dev.hspl.todo2ddd.user.application.usage;

import dev.hspl.todo2ddd.common.domain.value.UniversalUser;
import dev.hspl.todo2ddd.user.application.usage.command.UserLoginCommand;

public interface UserLoginUseCase {
    UniversalUser execute(UserLoginCommand command);
}
