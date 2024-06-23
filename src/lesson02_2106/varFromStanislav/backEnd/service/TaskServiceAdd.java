package lesson02_2106.varFromStanislav.backEnd.service;


import lesson02_2106.varFromStanislav.backEnd.dto.RequestDto;
import lesson02_2106.varFromStanislav.backEnd.dto.ResponseDto;
import lesson02_2106.varFromStanislav.backEnd.entity.Task;
import lesson02_2106.varFromStanislav.backEnd.repository.TaskRepository;
import lesson02_2106.varFromStanislav.backEnd.service.validation.Validation;

import java.util.List;

public class TaskServiceAdd {
    private final TaskRepository repository;
    private final Validation validation;

    public TaskServiceAdd(TaskRepository repository, Validation validation) {
        this.repository = repository;
        this.validation = validation;
    }

    public ResponseDto<Task> addNewTask (RequestDto requestDto){
        System.out.println("Received request: " + requestDto);

        //проводим валидацию данных
        List<String> errors = validation.validate(requestDto);

        if (errors.isEmpty()){
            Task taskForAdd = new Task (0, requestDto.getTitle(), requestDto.getDescription());
            Task savedTask = repository.add(taskForAdd);
            return new ResponseDto<>(200, savedTask, errors);
        }
        else{
            return new ResponseDto<>(400, new Task(), errors);
        }
    }
}
