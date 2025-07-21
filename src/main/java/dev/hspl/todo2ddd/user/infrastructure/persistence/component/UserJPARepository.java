package dev.hspl.todo2ddd.user.infrastructure.persistence.component;

import dev.hspl.todo2ddd.common.domain.value.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserJPARepository extends JpaRepository<UserJPAEntity, UUID> {
    @Query("SELECT u FROM User u WHERE u.username = :username AND u.role = :roleToMatch")
    Optional<UserJPAEntity> findByUsernameAndRoleMatch(
            @Param("username") String username,
            @Param("roleToMatch") UserRole roleToMatch
    );

    boolean existsByUsername(String username);
    // TODO: maybe we can optimize the query of this method (index only scan for username column)
}
