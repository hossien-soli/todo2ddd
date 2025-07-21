package dev.hspl.todo2ddd.common.application;

import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;
import dev.hspl.todo2ddd.common.domain.event.DomainEvent;

import java.util.Collection;

// publishing domain-events is an application level concern!!
// due to AbstractAggregateRoot's dependency on Spring Data repositories for event publishing, I decided to develop a custom event management solution
// org.springframework.data.domain.AbstractAggregateRoot

// for migrating to microservices we can create an impl of this interface for publishing events to an external message broker
// consider an Outbox-Pattern for talking to external systems
// always be aware of transaction scopes and consistency between different part of system(modules/microservices)

public interface DomainEventPublisher {
    void publish(DomainEvent event);

    void publishAll(Collection<? extends DomainEvent> events);

    void publishAll(DomainAggregateRoot aggregateRoot);
}
