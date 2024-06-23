package lesson02_2106.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks;
    private int nextId = 1;

    public TaskManager(){
    tasks = new ArrayList<>();
    tasks.add(new Task(nextId++, "Task 1", "Appointment at Dentist for Arina at 10/07"));
    tasks.add(new Task(nextId++, "Task 2", "School fest at 17/07 from 15:30"));
    }

    public void addTask(String title, String description) {
        Task task = new Task(nextId++, title, description);
        tasks.add(task);
    }

    public Optional<Task> findTaskById(int id) {
        return tasks.stream()
                    .filter(task -> task.getId() == id)
                    .findFirst();
        //Если задача с данным ID не найдена, Optional.empty() используется для явного указания на отсутствие задачи.
        // Это позволяет избежать возврата null и потенциальных ошибок NullPointerException.
    }

    public List<Task> findTasksByTitle(String title) {
        return tasks.stream()
                    .filter(task -> task.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public boolean deleteTaskById(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean updateTaskDescription(int id, String newDescription) {
        Optional<Task> taskOpt = findTaskById(id);
        if (taskOpt.isPresent()) {
            Task task = taskOpt.get();
            task.setDescription(newDescription);
            return true;
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}
