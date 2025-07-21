package dev.hspl.todo2ddd.user.infrastructure.persistence;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;
import dev.hspl.todo2ddd.user.application.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("cache")
@Primary
public class CachedUserRepository implements UserRepository {

    @Override
    public void save(User user) throws EntityVersionMismatchException {

    }

    @Override
    public boolean existsByUsername(Username username, UserRole userRole) {
        return true;
    }

    @Override
    public Optional<User> findByUsername(Username username, UserRole userRole) {
        return Optional.empty();
    }
}
