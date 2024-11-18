package kte.fullstack.backend.service.impl;

import kte.fullstack.backend.entity.TaskList;
import kte.fullstack.backend.repository.TaskListRepository;
import kte.fullstack.backend.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TasListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;



    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    public TaskList createTaskList(TaskList taskList) {
        if(taskList.getId() != null) {
            throw new IllegalArgumentException("TaskList id must be null");
        }
        if (taskList.getTitle() == null || taskList.getTitle().isBlank()) {
            throw new IllegalArgumentException("TaskList title must not be null or blank");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }
}
