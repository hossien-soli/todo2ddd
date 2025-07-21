package dev.hspl.todo2ddd.admin.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

// An entity for tracking user actions in the system (mostly client actions like a _todo creation or client registration...
// ...or client login)

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StatisticsEvent {
    private UUID id;

    private StatisticsEventAction action;

    private String userIdentifierValue;    // mostly user-id / nullable
    private String entityIdentifierValue;  // mostly entity-id(_todo-id) / nullable

    // we can also add some mata-data like ipAddress, userAgent, deviceType, os and ...
    // but for now this is enough maybe in the future we add some extra meta-data

    private LocalDateTime occurredAt;
}
