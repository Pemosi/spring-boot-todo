package com.example.todo.dto.request.tasks;

// import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.example.todo.entity.Project;
import com.example.todo.entity.Task;
import lombok.Data;

@Data
public class TaskBaseResponse {

  private Integer id;

  private Project project;

  private String name;

  private TaskPriorityResponse priority;

  private String memo;

  private String deadlineAt;

  private String completedAt;

  private String createdAt;

  private String updatedAt;

  public TaskBaseResponse(Task task) {
    this.id = task.getId();
    this.project = task.getProject();
    this.name = task.getName();
    this.priority = new TaskPriorityResponse(task.getPriority());
    this.memo = task.getMemo();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    this.deadlineAt = formatter.format(task.getDeadlineAt());
    this.completedAt = formatter.format(task.getCompletedAt());
    this.createdAt = formatter.format(task.getCreatedAt());
    this.updatedAt = formatter.format(task.getUpdatedAt());
  }

}
