package lesson02_2106.varFromStanislav.backEnd.repository;

import lesson02_2106.varFromStanislav.backEnd.entity.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private Integer nextId = 0;

    public Task add(Task task){
        task.setId(++nextId);
        tasks.add(task);
        return task;
    }

//    public Optional<Task> findByIdLoop (Integer id){
//        for (Task currentTask : tasks){
//            if (currentTask.getId().equals(id)){
//                return Optional.of(currentTask);
//            }
//        }
//        return Optional.empty();
//    }
    //Если задача с данным ID не найдена, Optional.empty() - для явного указания на отсутствие задачи,
    // что позволяет избежать возврата null и потенциальных ошибок NullPointerException.

    public Optional<Task> findById(Integer id) {
        return tasks.stream()
                .filter(currentTask -> currentTask.getId().equals(id))
                .findFirst();

    }

    public List<Task> findByTitle(String title) {
        return tasks.stream()
                .filter(currentTask -> currentTask.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    public boolean deleteTaskById(Integer id) {
        Optional<Task> foundedTaskById = findById(id);
        if(foundedTaskById.isPresent()){
            tasks.remove(foundedTaskById.get());
            return true;
        }else{
            return false;
        }
    }


}


