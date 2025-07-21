package dev.hspl.todo2ddd.common.infrastructure;

import dev.hspl.todo2ddd.common.application.UUIDGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultUUIDGenerator implements UUIDGenerator {
    @Override
    public UUID generateNew() {
        return UUID.randomUUID();
    }
}
