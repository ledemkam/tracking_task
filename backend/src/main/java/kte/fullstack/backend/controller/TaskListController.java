package kte.fullstack.backend.controller;

import kte.fullstack.backend.dto.TaskListDTO;
import kte.fullstack.backend.entity.TaskList;
import kte.fullstack.backend.mappers.TaskListMapper;
import kte.fullstack.backend.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    final TaskListService taskListService;
    final TaskListMapper taskListMapper;

    @GetMapping
    public List<TaskListDTO> getAllTaskLists() {
        return taskListService.getAllTaskLists()
                .stream()
                .map(taskListMapper::toDTO)
                .toList();
    }

    @PostMapping
    public TaskListDTO createTaskList(@RequestBody TaskListDTO taskListDTO) {
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDTO(taskListDTO)
        );
        return taskListMapper.toDTO(createdTaskList);
    }


}
