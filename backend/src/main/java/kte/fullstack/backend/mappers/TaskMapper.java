package kte.fullstack.backend.mappers;

import kte.fullstack.backend.dto.TaskDTO;
import kte.fullstack.backend.entity.Task;

public interface TaskMapper {
    Task fromDTO(TaskDTO dto);
    TaskDTO toDTO(Task task);
}
