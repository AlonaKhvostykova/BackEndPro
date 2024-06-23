package lesson02_2106.varFromStanislav;

import lesson02_2106.varFromStanislav.backEnd.repository.TaskRepository;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceAdd;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceDelete;
import lesson02_2106.varFromStanislav.backEnd.service.TaskServiceFind;
import lesson02_2106.varFromStanislav.backEnd.service.validation.Validation;
import lesson02_2106.varFromStanislav.frontEnd.ui.Ui;

public class App {
    public static void main(String[] args) {
        TaskRepository taskRepository = new TaskRepository();
        Validation validation = new Validation();
        TaskServiceAdd taskServiceAdd = new TaskServiceAdd(taskRepository, validation);
        TaskServiceFind taskServiceFind = new TaskServiceFind(taskRepository);
        TaskServiceDelete taskServiceDelete = new TaskServiceDelete(taskRepository);

        // Создаем экземпляр Ui и передаем необходимые сервисы
        Ui ui = new Ui(taskServiceAdd, taskServiceFind, taskServiceDelete);

        // Запускаем интерфейс пользователя
        ui.start();
    }
}
