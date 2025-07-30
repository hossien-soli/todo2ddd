package dev.hspl.todo2ddd.admin.application.usage.system;

import dev.hspl.todo2ddd.common.application.InvalidApplicationCommandException;

import java.time.LocalDateTime;

public record NewStatisticsEventCommand(
        String eventName,
        String relatedEntityName,  // nullable
        String relatedEntityId,     // nullable
        LocalDateTime eventOccurredAt
) {
    public NewStatisticsEventCommand {
        if (eventName == null || eventOccurredAt == null) {
            throw new InvalidApplicationCommandException("provided new statistics event command is invalid!");
        }
    }
}
