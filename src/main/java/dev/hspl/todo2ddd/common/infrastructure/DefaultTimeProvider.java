package dev.hspl.todo2ddd.common.infrastructure;

import dev.hspl.todo2ddd.common.application.TimeProvider;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DefaultTimeProvider implements TimeProvider {
    @Override
    public LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }
}
