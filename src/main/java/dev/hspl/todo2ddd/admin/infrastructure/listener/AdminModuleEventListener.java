package dev.hspl.todo2ddd.admin.infrastructure.listener;

import dev.hspl.todo2ddd.admin.application.usage.system.NewStatisticsEventCommand;
import dev.hspl.todo2ddd.admin.application.usage.system.NewStatisticsEventUseCase;
import dev.hspl.todo2ddd.common.domain.event.DomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

// This implementation of the event listener does not provide strong consistency (some events may be lost).

@Component
@RequiredArgsConstructor
public class AdminModuleEventListener {
    private final NewStatisticsEventUseCase newStatisticsEventUseCase;

    @TransactionalEventListener(
            fallbackExecution = true,
            condition = "#event.statistical()", // TODO: filter only statistical events
            phase = TransactionPhase.AFTER_COMMIT
    )
    @Async
    public void listenToAllDomainEvents(DomainEvent event) {
        var command = new NewStatisticsEventCommand(
                event.getClass().getSimpleName(),
                event.getPublisherAggregateRoot().getClass().getSimpleName(),
                event.getPublisherAggregateRoot().aggregateRootId().toString(),
                event.eventOccurredAt()
        );

        newStatisticsEventUseCase.execute(command);
    }
}
