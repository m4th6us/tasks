package com.manager.tasks.controllers;

import com.manager.tasks.models.ModelsTasks;
import com.manager.tasks.services.ServiceTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class ControllerTasks {

    @Autowired
    private ServiceTasks serviceTasks;

    @GetMapping
    public List<ModelsTasks> listAllTasks() {
        return serviceTasks.listAllTasks();
    }

    @PostMapping
    public ModelsTasks addTask(@RequestBody ModelsTasks modelsTasks) {
        return serviceTasks.save(modelsTasks);
    }

    @GetMapping("/{id}")
    public Optional<ModelsTasks> getById(@PathVariable Long id) {
        return serviceTasks.getById(id);
    }

    @PutMapping("/{id}")
    public ModelsTasks updateTask(@PathVariable Long id, @RequestBody ModelsTasks updatedModelsTasks) {

        Optional<ModelsTasks> existTask = serviceTasks.getById(id);
        if (existTask.isPresent()) {
            ModelsTasks modelsTasks = existTask.get();
            modelsTasks.setTask_description(updatedModelsTasks.getTask_description());
            modelsTasks.setTask_name(updatedModelsTasks.getTask_name());
            modelsTasks.setTask_status(updatedModelsTasks.isTask_status());
            return serviceTasks.save(modelsTasks);
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){

        Optional<ModelsTasks> existTask = serviceTasks.getById(id);
        if (existTask.isPresent()) {
            serviceTasks.delete(id);
            return "Deleted task id " + id + " successfully";
        }

        return "Not exist task for id " + id;

    }


}
