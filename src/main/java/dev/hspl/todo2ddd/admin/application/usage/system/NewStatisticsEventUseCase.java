package dev.hspl.todo2ddd.admin.application.usage.system;

// this is a system use-case that means only internal system calls can execute this use-case not users!!!
// internal system calls like -> events, direct api calls

public interface NewStatisticsEventUseCase {
    void execute(NewStatisticsEventCommand command);
}
