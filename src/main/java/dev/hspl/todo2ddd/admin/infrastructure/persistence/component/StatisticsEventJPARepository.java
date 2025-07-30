package dev.hspl.todo2ddd.admin.infrastructure.persistence.component;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticsEventJPARepository extends JpaRepository<StatisticsEventJPAEntity, UUID> {

}
