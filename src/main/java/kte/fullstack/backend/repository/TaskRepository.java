package kte.fullstack.backend.repository;

import kte.fullstack.backend.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskListId);
    Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID taskId);
    void deleteByTaskListIdAndId(UUID tasklistId, UUID taskId);
}
