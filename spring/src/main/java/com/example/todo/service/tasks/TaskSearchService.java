package com.example.todo.service.tasks;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.todo.dto.request.tasks.TaskSearchRequest;
import com.example.todo.dto.response.TaskBaseResponse;
import com.example.todo.repository.TaskRepository;
import com.example.todo.entity.Task;

@Service
public class TaskSearchService {

  private final TaskRepository taskRepository;

  public TaskSearchService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<TaskBaseResponse> invoke(TaskSearchRequest request) {
   List<Task> tasks =  this.taskRepository.findAll();

   return tasks.stream().map(task -> new TaskBaseResponse(task) ).collect(Collectors.toList());
  }
}
