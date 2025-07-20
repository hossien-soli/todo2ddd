package dev.hspl.todo2ddd.user.infrastructure.persistence.component;

import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.application.User;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper {

    @NonNull
    public UserJPAEntity mapUserToJPAEntity(@NonNull User user) {
        return UserJPAEntity.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername().value())
                .hashedPassword(user.getHashedPassword())
                .banned(user.isBanned())
                .registeredAt(user.getRegisteredAt())
                .role(user.getRole())
                .numberOfTodo(user.getNumberOfTodo())
                .version(user.getVersion())
                .build();
    }

    @NonNull
    public User mapJPAEntityToUser(@NonNull UserJPAEntity jpaEntity) {
        return User.existingUser(jpaEntity.getId(), jpaEntity.getFullName(), new Username(jpaEntity.getUsername()),
                jpaEntity.getHashedPassword(), jpaEntity.isBanned(), jpaEntity.getRegisteredAt(), jpaEntity.getRole(),
                jpaEntity.getNumberOfTodo(), jpaEntity.getVersion());
    }
}
