package dev.hspl.todo2ddd.common.domain.value;

import dev.hspl.todo2ddd.common.domain.exception.UnacceptableAccountUsernameException;

import java.util.regex.Pattern;

public record Username(String value) {
    private static final String USERNAME_REGEX = "^(?!.*(__|--))[a-zA-Z0-9_-]+$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REGEX);

    public static boolean validate(String username) {
        return username != null && username.length() >= 5 && username.length() <= 30
                && USERNAME_PATTERN.matcher(username).matches();
    }

    public Username {
        if (!validate(value)) {
            throw new UnacceptableAccountUsernameException();
        }

        value = value.toLowerCase();
    }

    @Override
    public String toString() {
        return value;
    }
}

