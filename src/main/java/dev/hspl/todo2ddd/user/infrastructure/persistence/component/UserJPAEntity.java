package dev.hspl.todo2ddd.user.infrastructure.persistence.component;

import dev.hspl.todo2ddd.common.domain.value.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserJPAEntity {
    @Id
    @Column(nullable = false, name = "id", updatable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false, name = "full_name", length = 40)
    private String fullName;

    @Column(nullable = false, name = "username", length = 30, unique = true)
    private String username;

    @Column(nullable = false, name = "password")
    private String hashedPassword;

    @Column(nullable = false, name = "banned")
    private boolean banned;

    @Column(nullable = false, name = "registered_at", updatable = false)
    private LocalDateTime registeredAt;

    @Column(nullable = false, name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false, name = "points")
    private int points = 0;

    @Column(nullable = true, name = "version")
    @Version
    private Integer version;
}
