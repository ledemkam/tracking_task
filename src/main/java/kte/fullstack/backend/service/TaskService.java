package kte.fullstack.backend.service;


import kte.fullstack.backend.model.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskService {

    Task createTask(UUID tasklistId ,Task task);
    List<Task> getAllTasks(UUID tasklistId);
    Optional<Task> getTaskById(UUID tasklistId, UUID taskId);
    Task updateTask(UUID tasklistId, UUID taskId, Task task);
    void deleteTask(UUID tasklistId, UUID taskId);
}
