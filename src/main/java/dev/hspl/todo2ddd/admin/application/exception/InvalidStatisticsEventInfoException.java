package dev.hspl.todo2ddd.admin.application.exception;

import dev.hspl.todo2ddd.common.application.ApplicationSystemException;

public class InvalidStatisticsEventInfoException extends ApplicationSystemException {
    public InvalidStatisticsEventInfoException() {
        super("information provided for statistics event are invalid!");
    }
}
