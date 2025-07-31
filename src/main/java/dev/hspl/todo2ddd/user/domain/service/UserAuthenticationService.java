package dev.hspl.todo2ddd.user.domain.service;

import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.domain.entity.User;
import dev.hspl.todo2ddd.user.domain.exception.*;
import dev.hspl.todo2ddd.user.domain.value.PlainPassword;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserAuthenticationService {
    private final PasswordProtector passwordProtector;
    private final UserUniquenessChecker uniquenessChecker;

    public User registerClient(
            LocalDateTime currentDateTime,
            UserId newUserId,
            String fullName,
            Username username,
            PlainPassword password,
            PlainPassword passwordConfirmation
    ) {
        if (!password.equals(passwordConfirmation)) {
            throw new PasswordConfirmationFailedException();
        }

        if (!uniquenessChecker.checkUsernameIsUnique(username,UserRole.CLIENT)) {
            throw new UsernameAlreadyInUseException();
        }

        return User.newClient(currentDateTime,newUserId,fullName,username,passwordProtector.protect(password));
    }
}
