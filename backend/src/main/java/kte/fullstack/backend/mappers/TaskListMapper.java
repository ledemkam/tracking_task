package kte.fullstack.backend.mappers;

import kte.fullstack.backend.dto.TaskListDTO;
import kte.fullstack.backend.entity.TaskList;

public interface TaskListMapper {
     TaskList fromDTO(TaskListDTO dto);
     TaskListDTO toDTO(TaskList taskList);
}

