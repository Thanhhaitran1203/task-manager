package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface ITaskRepository extends CrudRepository<Task,Long> {
}
