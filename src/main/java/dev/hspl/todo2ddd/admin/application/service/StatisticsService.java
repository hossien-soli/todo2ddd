package dev.hspl.todo2ddd.admin.application.service;

import dev.hspl.todo2ddd.admin.application.StatisticsEvent;
import dev.hspl.todo2ddd.admin.application.StatisticsEventRepository;
import dev.hspl.todo2ddd.admin.application.usage.system.NewStatisticsEventCommand;
import dev.hspl.todo2ddd.admin.application.usage.system.NewStatisticsEventUseCase;
import dev.hspl.todo2ddd.common.application.UUIDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StatisticsService implements NewStatisticsEventUseCase {
    private final StatisticsEventRepository repository;
    private final UUIDGenerator uuidGenerator;

    @Override
    public void execute(NewStatisticsEventCommand command) {
        StatisticsEvent event = StatisticsEvent.newEvent(
                uuidGenerator.generateNew(),
                command.eventName(),
                command.relatedEntityName(),
                command.relatedEntityId(),
                command.eventOccurredAt()
        );

        repository.save(event);
    }
}
