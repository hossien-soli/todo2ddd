package dev.hspl.todo2ddd.user.application.service;

import dev.hspl.todo2ddd.common.application.DomainEventPublisher;
import dev.hspl.todo2ddd.common.application.TimeProvider;
import dev.hspl.todo2ddd.common.application.UUIDGenerator;
import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.user.application.UserRepository;
import dev.hspl.todo2ddd.user.application.usage.ClientRegistrationUseCase;
import dev.hspl.todo2ddd.user.application.usage.command.ClientRegistrationCommand;
import dev.hspl.todo2ddd.user.domain.entity.User;
import dev.hspl.todo2ddd.user.domain.service.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthenticationApplicationService implements ClientRegistrationUseCase {
    private final UserAuthenticationService domainService;
    private final UUIDGenerator uuidGenerator;
    private final TimeProvider timeProvider;
    private final UserRepository userRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public void execute(ClientRegistrationCommand command) {
        User user = domainService.registerClient(
                timeProvider.currentDateTime(),
                new UserId(uuidGenerator.generateNew()),
                command.fullName(),
                command.username(),
                command.password(),
                command.passwordConfirmation()
        );

        userRepository.save(user);
        domainEventPublisher.publishAll(user); // be aware of transaction scope and consistency
    }
}
