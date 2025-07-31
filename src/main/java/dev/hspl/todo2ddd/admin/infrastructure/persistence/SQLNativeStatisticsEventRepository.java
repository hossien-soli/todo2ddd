package dev.hspl.todo2ddd.admin.infrastructure.persistence;

import dev.hspl.todo2ddd.admin.application.StatisticsEvent;
import dev.hspl.todo2ddd.admin.application.StatisticsEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

// Since JPA entities require an ID and the StatisticsEvent model lacks a unique identifier,
// we should use native SQL queries to store statistical events in a relational database.

@Repository
@Profile({"default", "sql-native"})
@RequiredArgsConstructor
public class SQLNativeStatisticsEventRepository implements StatisticsEventRepository {
    private final JdbcClient jdbcClient;

    @Override
    public void save(StatisticsEvent event) {
        String sql = """
                INSERT INTO statistics_events (event_name, entity_name, entity_id, occurred_at) \
                VALUES (:eventName, :entityName, :entityId, :occurredAt)\
                """;

        jdbcClient.sql(sql).param("eventName",event.getEventName())
                .param("entityName",event.getRelatedEntityName())
                .param("entityId",event.getRelatedEntityId())
                .param("occurredAt",event.getEventOccurredAt())
                .update();
    }
}
