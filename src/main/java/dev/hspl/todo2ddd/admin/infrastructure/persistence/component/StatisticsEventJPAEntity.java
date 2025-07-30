package dev.hspl.todo2ddd.admin.infrastructure.persistence.component;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "StatisticsEvent")
@Table(name = "statistics_events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatisticsEventJPAEntity implements Persistable<UUID> {
    @Id
    @Column(nullable = false,name = "id",updatable = false,columnDefinition = "UUID")
    private UUID id;

    @Column(nullable = false,name = "event_name",updatable = false,length = 50)
    private String eventName;

    @Column(nullable = true,name = "entity_name",updatable = false,length = 50)
    private String relatedEntityName;

    @Column(nullable = true,name = "entity_id",updatable = false,length = 100)
    private String relatedEntityId;

    @Column(nullable = false,name = "occurred_at",updatable = false)
    private LocalDateTime eventOccurredAt;

    @Override
    public boolean isNew() {
        return true; // statistics events are immutable, and we can't update them & because of this we treat every entity is new
    }
}
