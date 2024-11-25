package kte.fullstack.backend.service.impl;

import kte.fullstack.backend.model.entity.Task;
import kte.fullstack.backend.model.entity.TaskList;
import kte.fullstack.backend.model.entity.TaskPriority;
import kte.fullstack.backend.model.entity.TaskStatus;
import kte.fullstack.backend.repository.TaskListRepository;
import kte.fullstack.backend.repository.TaskRepository;
import kte.fullstack.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    final TaskRepository taskRepository;
    final TaskListRepository taskListRepository;

    @Override
    public Task createTask(UUID tasklistId, Task task) {
        if(task.getId() != null) {
            throw new IllegalArgumentException("Task id must be null");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title must not be null or blank");
        }

        TaskPriority priority = Optional.ofNullable(task.getPriority())
                                        .orElse(TaskPriority.MEDIUM);

        TaskList taskList = taskListRepository.findById(tasklistId)
                                              .orElseThrow(() -> new IllegalArgumentException("Invalid task list ID"));

        LocalDateTime now = LocalDateTime.now();

        return taskRepository.save(new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                TaskStatus.OPEN,
                priority,
                taskList,
                now,
                now
        ));

    }

    @Override
    public List<Task> getAllTasks(UUID tasklistId) {
        return taskRepository.findByTaskListId(tasklistId);

    }

    @Override
    public Optional<Task> getTaskById(UUID tasklistId,UUID taskId) {
        return taskRepository.findByTaskListIdAndId(tasklistId,taskId);
    }

    @Override
    public Task updateTask(UUID tasklistId, UUID taskId, Task task) {
        if (task.getId() == null) {
            throw new IllegalArgumentException("Task id must not be null");
        }
        if (!Objects.equals(taskId, task.getId())) {
            throw new IllegalArgumentException("Task id must match path variable");
        }

        if (task.getPriority() == null) {
            throw new IllegalArgumentException("Task priority must not be null");
        }
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Task status must not be null");
        }

        Task existingTask = taskRepository.findByTaskListIdAndId(tasklistId, task.getId())
                                          .orElseThrow(() -> new IllegalStateException("Task not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setDueDate(task.getDueDate());
        existingTask.setPriority(task.getPriority());
        existingTask.setStatus(task.getStatus());
        existingTask.setUpdated(LocalDateTime.now());
        existingTask.setStatus(task.getStatus());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(UUID tasklistId, UUID taskId) {
        taskRepository.deleteByTaskListIdAndId(tasklistId, taskId);
    }
}
