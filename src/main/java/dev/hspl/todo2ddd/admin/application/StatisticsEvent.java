package dev.hspl.todo2ddd.admin.application;

import dev.hspl.todo2ddd.admin.application.exception.InvalidStatisticsEventInfoException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

// StatisticsEvent = Some important domain-events that triggered by users stored for business analytics purposes.
// Statistics events are immutable

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StatisticsEvent {
    private final UUID id;  // this id is different from actual domain-event id

    private final String eventName; // event class name(can be domain-event or anything else important)
    // TODO: maybe add eventId (I think for now it is not necessary)

    private final String relatedEntityName;  // nullable(can be domain-entity(aggregate) or any other entity in the system)
    private final String relatedEntityId;    // nullable(can be domain-entity(aggregate) or any other entity in the system)
    // so this entity/class/model is generic and not related only to domain-events

    // we can also add some mata-data like ipAddress, userAgent, deviceType, os and ...
    // but for now this is enough maybe in the future we add some extra meta-data

    private final LocalDateTime eventOccurredAt; // occurrence of the actual event

    public static StatisticsEvent newEvent(
            UUID newId,
            String eventName,
            String relatedEntityName,
            String relatedEntityId,
            LocalDateTime eventOccurredAt
    ) {
        boolean validate = newId != null && eventName != null && eventName.length() <= 50 && eventOccurredAt != null;
        if (!validate) {
            throw new InvalidStatisticsEventInfoException();
        }

        return new StatisticsEvent(newId,eventName,relatedEntityName,relatedEntityId,eventOccurredAt);
    }
}
