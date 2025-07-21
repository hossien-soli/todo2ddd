package dev.hspl.todo2ddd.admin.application;

import dev.hspl.todo2ddd.common.application.EntityVersionMismatchException;

public interface StatisticsEventRepository {
    void save(StatisticsEvent event) throws EntityVersionMismatchException;
}
