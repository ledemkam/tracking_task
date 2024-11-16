package kte.fullstack.backend.dto;

import kte.fullstack.backend.entity.TaskPriority;
import kte.fullstack.backend.entity.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDTO(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
