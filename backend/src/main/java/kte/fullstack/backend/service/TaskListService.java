package kte.fullstack.backend.service;


import kte.fullstack.backend.entity.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> getAllTaskLists();
}
