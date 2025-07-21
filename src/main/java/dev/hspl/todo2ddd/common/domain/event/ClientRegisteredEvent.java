package dev.hspl.todo2ddd.common.domain.event;

import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.common.domain.value.Username;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

// Clients are regular users who can register in the system

@RequiredArgsConstructor
@ToString
public class ClientRegisteredEvent implements DomainEvent {
    private final LocalDateTime currentDateTime;

    @Getter
    private final UserId clientId;

    @Getter
    private final String clientFullName;

    @Getter
    private final Username clientUsername;

    @Override
    public LocalDateTime eventOccurredAt() {
        return currentDateTime;
    }
}
