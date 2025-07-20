package dev.hspl.todo2ddd.user.application;

import dev.hspl.todo2ddd.common.domain.value.UniversalUser;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.application.exception.InvalidUserInfoException;
import dev.hspl.todo2ddd.user.application.exception.UnacceptableAdminFullNameException;
import dev.hspl.todo2ddd.user.application.exception.UnacceptableClientFullNameException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User implements UniversalUser {
    private UUID id;

    private String fullName;

    private Username username;
    private String hashedPassword;

    private boolean banned;
    private LocalDateTime registeredAt;

    private UserRole role;

    private int numberOfTodo;

    private Integer version; // null=entity/model/record is NEW! | null=insert / not-null=update

    public static User newClient(String fullName, Username username, String hashedPassword) {
        boolean validateFullName = fullName != null && fullName.length() >= 5 && fullName.length() <= 30;
        if (!validateFullName) {
            throw new UnacceptableClientFullNameException();
        }

        boolean validateOtherUserInfo = username != null && hashedPassword != null && hashedPassword.length() == 60;
        if (!validateOtherUserInfo) {
            throw new InvalidUserInfoException();
        }

        return new User(UUID.randomUUID(), fullName, username, hashedPassword, false,
                LocalDateTime.now(), UserRole.CLIENT, 0, null);
    }

    public static User existingUser(UUID id, String fullName, Username username, String hashedPassword,
                                    boolean banned, LocalDateTime registeredAt, UserRole role, int numberOfTodo,
                                    Integer version) {
        // TODO: add validation
        return new User(id, fullName, username, hashedPassword, banned, registeredAt, role, numberOfTodo, version);
    }

    public static User newAdmin(String fullName, Username username, String hashedPassword) {
        boolean validateFullName = fullName != null && fullName.length() >= 5 && fullName.length() <= 40;
        if (!validateFullName) {
            throw new UnacceptableAdminFullNameException();
        }

        boolean validateOtherUserInfo = username != null && hashedPassword != null && hashedPassword.length() == 60;
        if (!validateOtherUserInfo) {
            throw new InvalidUserInfoException();
        }

        return new User(UUID.randomUUID(), fullName, username, hashedPassword, false,
                LocalDateTime.now(), UserRole.ADMIN, 0, null);
    }

    @Override
    public UUID universalUserId() {
        return id;
    }

    @Override
    public String universalUserFullName() {
        return fullName;
    }

    @Override
    public Username universalUserUsername() {
        return username;
    }

    @Override
    public UserRole userRole() {
        return role;
    }

    @Override
    public boolean isAccountActive() {
        return !banned;
    }
}
