package dev.hspl.todo2ddd.user.presentation.dto;

// request validation is done at the domain layer(single point for applying validation rules is better!!)

public record ClientRegistrationRequest(
        String fullName,
        String username,
        String password,
        String passwordConfirmation
) {
}
