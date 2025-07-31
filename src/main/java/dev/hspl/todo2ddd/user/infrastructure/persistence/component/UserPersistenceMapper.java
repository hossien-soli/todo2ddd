package dev.hspl.todo2ddd.user.infrastructure.persistence.component;

import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;
import dev.hspl.todo2ddd.user.domain.value.ProtectedPassword;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    @NonNull
    public UserJPAEntity mapUserToJPAEntity(@NonNull User user) {
        return UserJPAEntity.builder()
                .id(user.getId().value())
                .fullName(user.getFullName())
                .username(user.getUsername().value())
                .hashedPassword(user.getProtectedPassword().value())
                .banned(user.isBanned())
                .registeredAt(user.getRegisteredAt())
                .role(user.getRole())
                .points(user.getPoints())
                .version(user.getVersion())
                .build();
    }

    @NonNull
    public User mapJPAEntityToUser(@NonNull UserJPAEntity jpaEntity) {
        return User.existingUser(
                new UserId(jpaEntity.getId()),
                jpaEntity.getFullName(),
                new Username(jpaEntity.getUsername()),
                new ProtectedPassword(jpaEntity.getHashedPassword()),
                jpaEntity.isBanned(), jpaEntity.getRegisteredAt(),
                jpaEntity.getRole(), jpaEntity.getPoints(), jpaEntity.getVersion());
    }
}
