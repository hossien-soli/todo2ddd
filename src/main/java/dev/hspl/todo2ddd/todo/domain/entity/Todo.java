package dev.hspl.todo2ddd.todo.domain.entity;

import dev.hspl.todo2ddd.common.domain.DomainAggregateRoot;
import dev.hspl.todo2ddd.common.domain.event.*;
import dev.hspl.todo2ddd.common.domain.value.UserId;
import dev.hspl.todo2ddd.todo.domain.exception.*;
import dev.hspl.todo2ddd.todo.domain.value.TodoDescription;
import dev.hspl.todo2ddd.todo.domain.value.TodoPriority;
import dev.hspl.todo2ddd.todo.domain.value.TodoStatus;
import dev.hspl.todo2ddd.todo.domain.value.TodoTitle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

// domain entities should not have direct setters for their fields
// we should encapsulate entity state by using domain friendly mutator methods

// limit the number of _todo a client can have based on the UniversalUser.numberOfTodo(not limit for admin users)
// but use TodoCounter contract

// for a better example of an AggregateRoot see the Project AggregateRoot in taskbazi repository in my GitHub profile(hossien-soli)
// it aggregates the project and its collaborators in one big Entity or AggregateRoot and manges them together as a single unit of work or transaction

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo extends DomainAggregateRoot {
    private final UUID id;
    private final UserId userId;

    private TodoTitle title;
    private TodoDescription description; // optional/nullable
    private TodoPriority priority;

    private TodoStatus status;

    private LocalDateTime dueDateTime; // optional/nullable

    private boolean archived; // Only todos with the status COMPLETED, CANCELLED can be archived

    private final LocalDateTime createdAt;  // not-null / PENDING
    private LocalDateTime startedAt;  // nullable / PENDING -> IN_PROGRESS
    private LocalDateTime finishedAt; // nullable / IN_PROGRESS -> COMPLETED, CANCELLED, DEFERRED
    private LocalDateTime archivedAt; // nullable
    private LocalDateTime editedAt; // nullable

    public static Todo newTodo(
            LocalDateTime currentDateTime,
            UUID newTodoId,
            UserId userId,
            TodoTitle title,
            TodoDescription description, // nullable
            TodoPriority priority,
            LocalDateTime dueDateTime // nullable
    ) {
        boolean validate = currentDateTime != null && newTodoId != null && userId != null
                && title != null && priority != null;
        if (!validate) {
            throw new InvalidTodoInfoException();
        }

        Todo todo = new Todo(newTodoId,userId,title,description,priority,TodoStatus.PENDING,dueDateTime,false,
                currentDateTime,null,null,null,null);

        todo.registerDomainEvent(new TodoCreatedEvent(currentDateTime,userId,newTodoId,title));

        return todo;
    }

    public static Todo existingTodo(

    ) {

    }

    public void startTodo(LocalDateTime currentDateTime) {
        boolean isStartable = this.status.equals(TodoStatus.PENDING) || this.status.equals(TodoStatus.DEFERRED);
        if (!isStartable) {
            throw new TodoNotStartableException();
        }

        registerDomainEvent(new TodoStartedEvent(currentDateTime,this.userId,this.id,this.title));

        this.status = TodoStatus.IN_PROGRESS;
        this.startedAt = currentDateTime;
    }

    public void deferTodo(LocalDateTime currentDateTime) {
        boolean isDeferrable = this.status.equals(TodoStatus.PENDING) || this.status.equals(TodoStatus.IN_PROGRESS);
        if (!isDeferrable) {
            throw new TodoNotDeferrableException();
        }

        registerDomainEvent(new TodoDeferredEvent(currentDateTime,this.userId,this.id,this.title));

        this.status = TodoStatus.DEFERRED;
        this.finishedAt = currentDateTime;
    }

    public void completeTodo(LocalDateTime currentDateTime) {
        boolean isCompletable = this.status.equals(TodoStatus.IN_PROGRESS);
        if (!isCompletable) {
            throw new TodoNotCompletableException();
        }

        registerDomainEvent(new TodoCompletedEvent(currentDateTime,this.userId,this.id,this.title));

        this.status = TodoStatus.COMPLETED;
        this.finishedAt = currentDateTime;
    }

    public void cancelTodo(LocalDateTime currentDateTime) {
        boolean isCancellable = this.status.equals(TodoStatus.PENDING) || this.status.equals(TodoStatus.IN_PROGRESS)
                || this.status.equals(TodoStatus.DEFERRED);
        if (!isCancellable) {
            throw new TodoNotCancellableException();
        }

        registerDomainEvent(new TodoCancelledEvent(currentDateTime,this.userId,this.id,this.title));

        this.status = TodoStatus.CANCELLED;
        this.finishedAt = currentDateTime;
    }

    // this method will replace all fields with new values(null can replace non-null values)
    public void editTodo(
            LocalDateTime currentDateTime,
            TodoTitle newTitle,
            TodoDescription newDescription, // nullable
            TodoPriority newPriority,
            LocalDateTime newDueDateTime // nullable
    ) {
        boolean validate = currentDateTime != null && newTitle != null && newPriority != null;
        if (!validate) {
            throw new InvalidTodoInfoException();
        }

        this.title = newTitle;
        this.description = newDescription;
        this.priority = newPriority;
        this.dueDateTime = newDueDateTime;
        this.editedAt = currentDateTime;
    }

    @Override
    public Object aggregateRootId() {
        return id;
    }
}
