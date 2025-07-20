package dev.hspl.todo2ddd.user.infrastructure.persistence;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.application.User;
import dev.hspl.todo2ddd.user.application.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("sql-native")
@RequiredArgsConstructor
public class SQLNativeUserRepository implements UserRepository {
    private final JdbcClient jdbcClient;

    @Override
    public void save(User user) throws EntityVersionMismatchException {
        boolean isNew = user.getVersion() == null || user.getVersion() == 0;
        if (isNew) { // insert
            String sql = """
                    INSERT INTO users (id, full_name, username, password, banned, registered_at, role, todo_count, version) \
                    VALUES (:id, :fullName, :username, :password, :banned, :registeredAt, :role, :todoCount, :version)\
                    """;

            jdbcClient.sql(sql).param("id",user.getId()).param("fullName",user.getFullName())
                    .param("username",user.getUsername().value()).param("password",user.getHashedPassword())
                    .param("banned",user.isBanned()).param("registeredAt",user.getRegisteredAt())
                    .param("role",user.getRole()).param("todoCount",user.getNumberOfTodo())
                    .param("version",1)
                    .update();
        } else { // update

        }
    }

    @Override
    public Optional<User> findByUsername(Username username, UserRole roleToMatch) {
        return Optional.empty();
    }
}
