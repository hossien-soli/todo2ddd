package dev.hspl.todo2ddd.admin.application;

// statistics events are immutable never try to update them in the database(save method always executes and insert!)
// statistics events don't need id or primary key(storage efficiency)

public interface StatisticsEventRepository {
    void save(StatisticsEvent event);
}
