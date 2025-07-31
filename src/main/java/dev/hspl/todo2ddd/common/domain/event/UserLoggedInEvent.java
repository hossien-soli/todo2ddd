package dev.hspl.todo2ddd.common.domain.event;

import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.common.domain.value.UserRole;
import dev.hspl.todo2ddd.common.domain.value.Username;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@ToString
public class UserLoggedInEvent extends DomainEvent {
    private final LocalDateTime currentDateTime;

    @Getter
    private final UserRole userRole;

    @Getter
    private final UserId userId;

    @Getter
    private final Username userUsername;

    // maybe adding some metadata about request is useful like ip / user-agent

    @Override
    public LocalDateTime eventOccurredAt() {
        return currentDateTime;
    }

    @Override
    public boolean statistical() {
        return false;
    }
}
