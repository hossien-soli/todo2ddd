package dev.hspl.todo2ddd.admin.application;

// statistics events are immutable never try to update them in the database(save method always executes and insert!)

public interface StatisticsEventRepository {
    void save(StatisticsEvent event);
}
