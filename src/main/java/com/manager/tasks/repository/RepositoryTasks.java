package com.manager.tasks.repository;

import com.manager.tasks.models.ModelsTasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTasks extends JpaRepository<ModelsTasks, Long> {
}
