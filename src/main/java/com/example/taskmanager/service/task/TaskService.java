package com.example.taskmanager.service.task;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TaskService implements ITaskService<Task>{
    @Autowired
    private ITaskRepository taskRepository;
    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    taskRepository.deleteById(id);
    }
}
