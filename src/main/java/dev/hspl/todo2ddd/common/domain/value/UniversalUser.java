package dev.hspl.todo2ddd.common.domain.value;

import java.util.UUID;

// A representation of user for the domain layer(understandable by the domain layer)

public interface UniversalUser {
    UUID universalUserId();

    String universalUserFullName();

    Username universalUserUsername();

    UserRole userRole();

    boolean isAccountActive();
}
