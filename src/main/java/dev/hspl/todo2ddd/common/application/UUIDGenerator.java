package dev.hspl.todo2ddd.common.application;

import java.util.UUID;

// generates universally unique identifier for entities
// it should be implemented in the infrastructure layer
// The domain layer shouldn't be aware of how UUIDs are generated

public interface UUIDGenerator {
    UUID generateNew();
}
