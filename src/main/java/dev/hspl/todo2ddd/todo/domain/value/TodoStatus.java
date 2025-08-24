package dev.hspl.todo2ddd.todo.domain.value;

// Only todos with the status COMPLETED, CANCELLED can be archived

public enum TodoStatus {
    PENDING, // Created
    IN_PROGRESS,  // Started
    COMPLETED,
    CANCELLED,
    DEFERRED
}
