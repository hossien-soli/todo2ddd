package dev.hspl.todo2ddd.common.infrastructure;

import dev.hspl.todo2ddd.common.application.DomainEventPublisher;
import dev.hspl.todo2ddd.common.application.UUIDGenerator;
import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;
import dev.hspl.todo2ddd.common.domain.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

// for a modular-monolithic application the spring event bus is perfect
// for migrating to microservices we can create an impl of this interface for publishing events to an external message broker
// consider an Outbox-Pattern for talking to external systems
// always be aware of transaction scopes and consistency between different part of system(modules/microservices)

@Component
@RequiredArgsConstructor
public class SpringEventBusDomainEventPublisher implements DomainEventPublisher {
    private final ApplicationEventPublisher springEventPublisher;
    private final UUIDGenerator uuidGenerator;

    @Override
    public void publishAll(DomainAggregateRoot aggregateRoot) {
        for (DomainEvent event : aggregateRoot.domainEvents()) {
            event.setUniversalEventId(uuidGenerator.generateNew());
            event.setPublisherAggregateRoot(aggregateRoot);

            springEventPublisher.publishEvent(event);
        }

        aggregateRoot.clearDomainEvents();
    }
}

