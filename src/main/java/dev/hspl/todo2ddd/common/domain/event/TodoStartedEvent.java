package dev.hspl.todo2ddd.common.domain.event;

import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.todo.domain.value.TodoTitle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@RequiredArgsConstructor
@ToString
public class TodoStartedEvent extends DomainEvent {
    private final LocalDateTime currentDateTime;

    @Getter
    private final UserId creatorUserId;

    @Getter
    private final UUID todoId;

    @Getter
    private final TodoTitle todoTitle; // maybe needed for notification in the future

    @Override
    public LocalDateTime eventOccurredAt() {
        return currentDateTime;
    }

    @Override
    public boolean statistical() {
        return false;
    }
}
