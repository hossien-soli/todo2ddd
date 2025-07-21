package dev.hspl.todo2ddd.user.infrastructure.persistence;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;
import dev.hspl.todo2ddd.user.application.UserRepository;
import dev.hspl.todo2ddd.user.infrastructure.persistence.component.UserJPARepository;
import dev.hspl.todo2ddd.user.infrastructure.persistence.component.UserPersistenceMapper;
import jakarta.persistence.OptimisticLockException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile({"default", "sql-jpa"})
@RequiredArgsConstructor
public class SQLJPAUserRepository implements UserRepository {
    private final UserJPARepository jpaRepository;
    private final UserPersistenceMapper persistenceMapper;

    @Override
    public void save(User user) throws EntityVersionMismatchException {
        try {
            jpaRepository.save(persistenceMapper.mapUserToJPAEntity(user));
        } catch (OptimisticLockException exception) {
            throw new EntityVersionMismatchException(User.class.getName(), user.getId(), false);
        }
    }

    @Override
    public boolean existsByUsername(Username username, UserRole userRole) {
        return jpaRepository.existsByUsername(username.value());
    }

    @Override
    public Optional<User> findByUsername(Username username, UserRole userRole) {
        return jpaRepository.findByUsernameAndRoleMatch(username.value(), userRole)
                .map(persistenceMapper::mapJPAEntityToUser);
    }
}
