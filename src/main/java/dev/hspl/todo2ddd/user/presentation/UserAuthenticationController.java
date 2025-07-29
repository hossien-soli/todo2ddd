package dev.hspl.todo2ddd.user.presentation;

import dev.hspl.todo2ddd.common.domain.value.Username;
import dev.hspl.todo2ddd.user.application.usage.ClientRegistrationUseCase;
import dev.hspl.todo2ddd.user.application.usage.command.ClientRegistrationCommand;
import dev.hspl.todo2ddd.user.domain.value.PlainPassword;
import dev.hspl.todo2ddd.user.presentation.dto.ClientRegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthenticationController {
    private final ClientRegistrationUseCase registrationUseCase;

    @PostMapping("/client/register")
    @ResponseStatus(HttpStatus.OK)
    public void registerClient(
            @RequestBody ClientRegistrationRequest payload
    ) {
        // request validation is done at the domain layer(single point for applying validation rules is better!!)
        var command = new ClientRegistrationCommand(
                payload.fullName(),
                new Username(payload.username()),
                new PlainPassword(payload.password()),
                new PlainPassword(payload.passwordConfirmation())
        );

        registrationUseCase.execute(command);
    }
}
