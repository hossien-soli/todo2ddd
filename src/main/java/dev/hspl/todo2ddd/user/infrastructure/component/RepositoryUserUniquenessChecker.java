package dev.hspl.todo2ddd.user.infrastructure.component;

import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.application.UserRepository;
import dev.hspl.todo2ddd.user.domain.service.UserUniquenessChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// in simple application checking uniqueness by querying the database is fine
// but for large scale application with many user we can use other methods for uniqueness checks
// and this can be done simply only by a new implementation of this interface and no need to change the domain layer!!

@Component
@RequiredArgsConstructor
public class RepositoryUserUniquenessChecker implements UserUniquenessChecker {
    private final UserRepository userRepository;

    @Override
    public boolean checkUsernameIsUnique(Username username, UserRole userRole) {
        return !userRepository.existsByUsername(username, userRole);
    }
}
