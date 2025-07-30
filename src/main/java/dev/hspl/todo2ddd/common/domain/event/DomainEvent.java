package dev.hspl.todo2ddd.common.domain.event;

import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

// due to AbstractAggregateRoot's dependency on Spring Data repositories for event publishing, I decided to develop a custom event management solution
// org.springframework.data.domain.AbstractAggregateRoot
// a domain-event only can be published by an aggregate root

// the universalEventId & publisherAggregateRoot fields are set only at the time of publishing the event by DomainEventPublisher
// because we only need these fields after event publication on other parties of the system(other modules or services)
// the word universal in the universalEventId fields is because after publication we treat the event related to whole system

@Getter
@Setter
public abstract class DomainEvent {
    private UUID universalEventId = null;
    private DomainAggregateRoot publisherAggregateRoot = null;

    public abstract LocalDateTime eventOccurredAt();

    public abstract boolean statistical();
}
