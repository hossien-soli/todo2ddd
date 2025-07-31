package dev.hspl.todo2ddd.user.domain.entity;

import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;
import dev.hspl.todo2ddd.common.domain.event.ClientRegisteredEvent;
import dev.hspl.todo2ddd.common.domain.value.UniversalUser;
import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.exception.InvalidUserInfoException;
import dev.hspl.todo2ddd.user.domain.exception.UnacceptableAdminFullNameException;
import dev.hspl.todo2ddd.user.domain.exception.UnacceptableClientFullNameException;
import dev.hspl.todo2ddd.user.domain.value.ProtectedPassword;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

// domain entities should not have direct setters for their fields
// we should encapsulate entity state by using domain friendly mutator methods

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends DomainAggregateRoot implements UniversalUser {
    private UserId id;

    private String fullName;

    private Username username;
    private ProtectedPassword protectedPassword;

    private boolean banned;
    private LocalDateTime registeredAt;

    private UserRole role;

    private int points;
    // each _todo creation give user a 2 point and other _todo operation give it 1 point

    private Integer version; // null=entity/model/record is NEW! | null=insert / not-null=update

    public static User newClient(
            LocalDateTime currentDateTime,
            UserId newUserId,
            String fullName,
            Username username,
            ProtectedPassword protectedPassword
    ) {
        boolean validateFullName = fullName != null && fullName.length() >= 5 && fullName.length() <= 30;
        if (!validateFullName) {
            throw new UnacceptableClientFullNameException();
        }

        boolean validateOtherUserInfo = currentDateTime != null && newUserId != null &&
                username != null && protectedPassword != null;
        if (!validateOtherUserInfo) {
            throw new InvalidUserInfoException();
        }

        User user = new User(newUserId, fullName, username, protectedPassword, false,
                currentDateTime, UserRole.CLIENT, 5, null);

        user.registerDomainEvent(new ClientRegisteredEvent(currentDateTime, newUserId, fullName, username));

        return user;
    }

    public static User newAdmin(
            LocalDateTime currentDateTime,
            UserId newUserId,
            String fullName,
            Username username,
            ProtectedPassword protectedPassword
    ) {
        boolean validateFullName = fullName != null && fullName.length() >= 5 && fullName.length() <= 40;
        if (!validateFullName) {
            throw new UnacceptableAdminFullNameException();
        }

        boolean validateOtherUserInfo = currentDateTime != null && newUserId != null &&
                username != null && protectedPassword != null;
        if (!validateOtherUserInfo) {
            throw new InvalidUserInfoException();
        }

        return new User(newUserId, fullName, username, protectedPassword, false,
                currentDateTime, UserRole.ADMIN, 0, null);
    }

    public static User existingUser(UserId id, String fullName, Username username, ProtectedPassword protectedPassword,
                                    boolean banned, LocalDateTime registeredAt,
                                    UserRole role, int points, Integer version) {
        // TODO: add validation
        return new User(id, fullName, username, protectedPassword, banned, registeredAt, role, points, version);
    }

    @Override
    public Object aggregateRootId() {
        return id;
    }

    @Override
    public UserId universalUserId() {
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
