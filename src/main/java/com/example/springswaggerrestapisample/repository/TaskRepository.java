package com.example.springswaggerrestapisample.repository;

import com.example.springswaggerrestapisample.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// REST APIのCRUDを自動生成します
@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task, Long> {
}
