package kte.fullstack.backend.service.impl;

import kte.fullstack.backend.entity.TaskList;
import kte.fullstack.backend.repository.TaskListRepository;
import kte.fullstack.backend.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TasListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;



    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }
}
