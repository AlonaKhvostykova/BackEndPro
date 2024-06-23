package lesson02_2106.varFromStanislav.backEnd.service;


import lesson02_2106.varFromStanislav.backEnd.dto.ResponseDto;
import lesson02_2106.varFromStanislav.backEnd.entity.Task;
import lesson02_2106.varFromStanislav.backEnd.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskServiceFind {
    private final TaskRepository repository;

    public TaskServiceFind(TaskRepository repository) {
        this.repository = repository;
    }

    public ResponseDto<Task> findTaskById(Integer id) {
        System.out.println("Searching for task with ID: " + id);
        Optional<Task> foundTask = repository.findById(id);

        if (foundTask.isPresent()) {
            return new ResponseDto<>(200, foundTask.get(), List.of());
        } else {
            return new ResponseDto<>(400, new Task(), List.of("Task not found with the given id"));
        }
    }

    public ResponseDto<List<Task>> findTasksByTitle(String title) {
        System.out.println("Searching for tasks with title: " + title);
        List<Task> foundTasks = repository.findByTitle(title);

        if (!foundTasks.isEmpty()) {
            return new ResponseDto<>(200, foundTasks, List.of());
        } else {
            return new ResponseDto<>(400, List.of(), List.of("No tasks found with the given title"));
        }
    }
}
