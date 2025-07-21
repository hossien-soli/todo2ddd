package dev.hspl.todo2ddd.user.domain.service;

import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;

// in simple application checking uniqueness by querying the database is fine
// but for large scale application with many user we can use other methods for uniqueness checks
// and this can be done simply only by a new implementation of this interface and no need to change the domain layer!!

public interface UserUniquenessChecker {
    boolean checkUsernameIsUnique(
            Username username,
            UserRole userRole   // useful only when we want to store different roles in different locations/tables...
    );

    // maybe checkEmailIsUnique(EmailAddress) in the future
}
