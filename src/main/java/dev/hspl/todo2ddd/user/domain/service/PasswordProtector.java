package dev.hspl.todo2ddd.user.domain.service;

import dev.hspl.todo2ddd.user.domain.value.PlainPassword;
import dev.hspl.todo2ddd.user.domain.value.ProtectedPassword;

// The domain layer shouldn't be concerned with hashing at all — it's an implementation detail that belongs elsewhere
// However, this rule of hashing should be enforced within the business rules or domain layer
// So, I defined this contract

public interface PasswordProtector {
    ProtectedPassword protect(PlainPassword plainPassword);
    boolean matches(PlainPassword plainPassword, ProtectedPassword protectedPassword);
}
