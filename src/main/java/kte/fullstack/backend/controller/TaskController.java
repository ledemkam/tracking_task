package kte.fullstack.backend.controller;

import kte.fullstack.backend.mappers.TaskMapper;
import kte.fullstack.backend.model.dto.TaskDTO;
import kte.fullstack.backend.model.entity.Task;
import kte.fullstack.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/task-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public TaskDTO createTask(@PathVariable("task_list_id") UUID tasklistId, @RequestBody TaskDTO taskDTO) {
        Task createdTask = taskService.createTask(tasklistId,taskMapper.fromDTO(taskDTO));
        return taskMapper.toDTO(createdTask);

    }

    @GetMapping
    public List<TaskDTO> getAllTasks(@PathVariable("task_list_id") UUID tasklistId) {
        return taskService.getAllTasks(tasklistId)
                .stream()
                .map(taskMapper::toDTO)
                .toList();
    }

    @GetMapping(path = "/{task_id}")
    public TaskDTO getTaskById(@PathVariable("task_list_id") UUID tasklistId, @PathVariable("task_id") UUID taskId) {
        return taskService.getTaskById(tasklistId, taskId)
                .map(taskMapper::toDTO)
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + taskId + " not found"));
    }

    @PutMapping(path = "/{task_id}")
    public TaskDTO updateTask(@PathVariable("task_list_id") UUID tasklistId, @PathVariable("task_id") UUID taskId, @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.updateTask(tasklistId, taskId, taskMapper.fromDTO(taskDTO));
        return taskMapper.toDTO(updatedTask);
    }

    @DeleteMapping(path = "/{task_id}")
    public void deleteTask(@PathVariable("task_list_id") UUID tasklistId, @PathVariable("task_id") UUID taskId) {
        taskService.deleteTask(tasklistId, taskId);
    }

}
