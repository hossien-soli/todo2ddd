package dev.hspl.todo2ddd.common.application;

import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;

// publishing domain-events is an application level concern!!
// due to AbstractAggregateRoot's dependency on Spring Data repositories for event publishing, I decided to develop a custom event management solution
// org.springframework.data.domain.AbstractAggregateRoot

// for migrating to microservices we can create an impl of this interface for publishing events to an external message broker
// consider an Outbox-Pattern for talking to external systems
// always be aware of transaction scopes and consistency between different part of system(modules/microservices)

// a domain-event only can be published by an aggregate root

public interface DomainEventPublisher {
    void publishAll(DomainAggregateRoot aggregateRoot);
}
