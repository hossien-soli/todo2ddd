package dev.hspl.todo2ddd.common.application;

import java.time.LocalDateTime;

public interface TimeProvider {
    LocalDateTime currentDateTime();
}
