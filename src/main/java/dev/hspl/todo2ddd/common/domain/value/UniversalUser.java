package dev.hspl.todo2ddd.common.domain.value;

// A representation of user for the domain layer(understandable by the domain layer)

public interface UniversalUser {
    UserId universalUserId();

    String universalUserFullName();

    Username universalUserUsername();

    UserRole userRole();

    boolean isAccountActive();
}
