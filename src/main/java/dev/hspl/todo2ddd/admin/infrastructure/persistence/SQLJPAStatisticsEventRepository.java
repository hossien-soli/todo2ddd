package dev.hspl.todo2ddd.admin.infrastructure.persistence;

import dev.hspl.todo2ddd.admin.application.StatisticsEvent;
import dev.hspl.todo2ddd.admin.application.StatisticsEventRepository;
import dev.hspl.todo2ddd.admin.infrastructure.persistence.component.StatisticsEventJPAEntity;
import dev.hspl.todo2ddd.admin.infrastructure.persistence.component.StatisticsEventJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile({"default", "sql-jpa"})
@RequiredArgsConstructor
public class SQLJPAStatisticsEventRepository implements StatisticsEventRepository {
    private final StatisticsEventJPARepository jpaRepository;

    @Override
    public void save(StatisticsEvent event) {
        StatisticsEventJPAEntity jpaEntity = StatisticsEventJPAEntity.builder()
                .id(event.getId())
                .eventName(event.getEventName())
                .relatedEntityName(event.getRelatedEntityName())
                .relatedEntityId(event.getRelatedEntityId())
                .eventOccurredAt(event.getEventOccurredAt())
                .build();

        jpaRepository.save(jpaEntity);
    }
}
