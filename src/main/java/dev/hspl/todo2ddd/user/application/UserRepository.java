package dev.hspl.todo2ddd.user.application;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;

import java.util.Optional;

public interface UserRepository {
    void save(User user) throws EntityVersionMismatchException;

    Optional<User> findByUsername(Username username, UserRole roleToMatch);
}
