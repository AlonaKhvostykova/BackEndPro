package lesson02_2106.varFromStanislav.backEnd.service;

import lesson02_2106.varFromStanislav.backEnd.dto.ResponseDto;
import lesson02_2106.varFromStanislav.backEnd.entity.Task;
import lesson02_2106.varFromStanislav.backEnd.repository.TaskRepository;

import java.util.List;

public class TaskServiceDelete {
    private TaskRepository repository;

    public TaskServiceDelete(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> deleteTaskById(Integer id) {
        System.out.println("Deleting task with ID: " + id);
        boolean isDeleted = repository.deleteTaskById(id);

        if (isDeleted) {
            return new ResponseDto<>(200, null, List.of());
        } else {
            return new ResponseDto<>(400, null, List.of("Task not found with the given id"));
        }
    }
}
