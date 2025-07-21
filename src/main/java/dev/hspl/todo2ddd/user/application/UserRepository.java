package dev.hspl.todo2ddd.user.application;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user) throws EntityVersionMismatchException;
    // we can use the role field for storing different roles in different ways/locations/tables

    boolean existsByUsername(Username username, UserRole userRole);
    // if we store all type of users in one table, and we have an index on username column in that table we shouldn't apply userRole match(just filter by username)

    Optional<User> findByUsername(Username username, UserRole userRole);
    // role is useful we want to store different roles in different locations/tables
}
