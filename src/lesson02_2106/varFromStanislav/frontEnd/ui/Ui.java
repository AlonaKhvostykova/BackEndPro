package lesson02_2106.varFromStanislav.frontEnd.ui;

import lesson02_2106.varFromStanislav.backEnd.dto.RequestDto;
import lesson02_2106.varFromStanislav.backEnd.dto.ResponseDto;
import lesson02_2106.varFromStanislav.backEnd.entity.Task;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceAdd;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceDelete;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceFind;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private TaskServiceAdd addService;
    private TaskServiceFind findService;
    private TaskServiceDelete deleteService;

    public Ui(TaskServiceAdd addService, TaskServiceFind findService, TaskServiceDelete deleteService) {
        this.addService = addService;
        this.findService = findService;
        this.deleteService = deleteService;
    }

    public void start(){
        while(true){
            System.out.println("Please enter your choice: ");
            System.out.println("1. Add new task");
            System.out.println("2. Find task by id");
            System.out.println("3. Find task by name");
            System.out.println("4. Delete task by id");
            System.out.println("5. Exit");


            Scanner scanner = new Scanner(System.in);

            int userInput = scanner.nextInt();
            scanner.nextLine();

             switch (userInput){
                case 1:
                    System.out.println("Please enter task name:");
                    String taskName = scanner.nextLine();
                    System.out.println("Please enter task description:");
                    String taskDescription = scanner.nextLine();

                   ResponseDto<Task> responseDto =  addService.addNewTask(new RequestDto(taskName, taskDescription));

                    if(responseDto.getResponceCode() == 200){
                        System.out.println("Task was added successfully");
                    }else {
                        System.out.println(responseDto.getErrors());
                    }
                    break;

                case 2:
                    System.out.println("Please enter task id:");
                    Integer taskId = scanner.nextInt();

                    ResponseDto<Task> taskByIdResponse = findService.findTaskById(taskId);

                    if (taskByIdResponse.getResponceCode() == 200) {
                        System.out.println("Task found: " + taskByIdResponse.getResult());
                    } else {
                        System.out.println(taskByIdResponse.getErrors());
                    }
                    break;
                case 3:
                    System.out.println("Please enter task name:");
                    String taskTitle = scanner.nextLine();

                    ResponseDto<List<Task>> tasksByTitleResponse = findService.findTasksByTitle(taskTitle);
                    if (tasksByTitleResponse.getResponceCode() == 200) {
                        List<Task> tasks = tasksByTitleResponse.getResult();
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks found with the given title.");
                        } else {
                            tasks.forEach(task -> System.out.println("Task found: " + task));
                        }
                    } else {
                        System.out.println(tasksByTitleResponse.getErrors());
                    }
                    break;
                case 4:
                    System.out.println("Please enter task id to delete:");
                    Integer deleteTaskId = scanner.nextInt();

                    ResponseDto<Task> deleteResponse = deleteService.deleteTaskById(deleteTaskId);

                    if (deleteResponse.getResponceCode() == 200) {
                        System.out.println("Task was deleted successfully");
                    } else {
                        System.out.println(deleteResponse.getErrors());
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

}
