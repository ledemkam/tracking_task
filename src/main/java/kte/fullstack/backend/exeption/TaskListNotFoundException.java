package kte.fullstack.backend.exeption;

import java.util.UUID;

public class TaskListNotFoundException extends NotFoundException {
    public TaskListNotFoundException(String message) {
        super(message);
    }

    public static TaskListNotFoundException withId(UUID taskListId) {
        return new TaskListNotFoundException("Task list with ID " + taskListId + " not found.");
    }


}
