package com.manager.tasks.services;

import com.manager.tasks.models.ModelsTasks;
import com.manager.tasks.repository.RepositoryTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTasks {

    @Autowired
    private RepositoryTasks repositoryTasks;

    public List<ModelsTasks> listAllTasks() {
        return repositoryTasks.findAll();
    }

    public Optional<ModelsTasks> getById(Long id) {
        return repositoryTasks.findById(id);
    }

    public ModelsTasks save(ModelsTasks modelsTasks) {
        return repositoryTasks.save(modelsTasks);
    }

    public void delete(Long id) {
        repositoryTasks.deleteById(id);
    }

}
