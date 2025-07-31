package dev.hspl.todo2ddd.user.infrastructure.persistence;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;
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
                    INSERT INTO users (id, full_name, username, password, banned, registered_at, role, points, version) \
                    VALUES (:id, :fullName, :username, :password, :banned, :registeredAt, :role, :points, :version)\
                    """;

            jdbcClient.sql(sql).param("id",user.getId().value()).param("fullName",user.getFullName())
                    .param("username",user.getUsername().value()).param("password",user.getProtectedPassword().value())
                    .param("banned",user.isBanned()).param("registeredAt",user.getRegisteredAt())
                    .param("role",user.getRole()).param("points",user.getPoints())
                    .param("version",1)
                    .update();
        } else { // update

        }
    }

    @Override
    public boolean existsByUsername(Username username, UserRole userRole) {
        return true;
    }

    @Override
    public Optional<User> findByUsername(Username username, UserRole roleToMatch) {
        return Optional.empty();
    }
}
