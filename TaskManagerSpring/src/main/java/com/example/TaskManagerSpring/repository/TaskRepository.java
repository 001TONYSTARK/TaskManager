package com.example.TaskManagerSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskManagerSpring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional query methods can be defined here if needed
}
