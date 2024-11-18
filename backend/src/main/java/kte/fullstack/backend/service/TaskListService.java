package kte.fullstack.backend.service;


import kte.fullstack.backend.model.entity.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> getAllTaskLists();
    public TaskList createTaskList(TaskList taskList);
}
