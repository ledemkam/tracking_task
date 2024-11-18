package kte.fullstack.backend.controller;

import kte.fullstack.backend.dto.TaskListDTO;
import kte.fullstack.backend.mappers.TaskListMapper;
import kte.fullstack.backend.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
