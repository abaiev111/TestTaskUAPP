package com.gmail.aba.service;

import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.TaskDetailsDTO;
import com.gmail.aba.dto.TaskUpdateColumnDTO;
import com.gmail.aba.dto.TaskUpdateDTO;
import com.gmail.aba.dto.TaskUpdateOrderDTO;
import com.gmail.aba.repository.TaskRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    TaskRepoImpl taskRepo;

    public int createTask(TaskData task) {
        return taskRepo.save(task);
    }

    public TaskDetailsDTO getTaskById(int id) {
        return taskRepo.findById(id);
    }

    public String updateTask(TaskUpdateDTO task, int id) {
        taskRepo.updateTask(task, id);
        return "task updated";
    }

    public String updateTaskByOrder(TaskUpdateOrderDTO task, int id) {
        taskRepo.updateTaskByOrder(task, id);
        return "task order updated";
    }

    public String updateTaskByColumn(TaskUpdateColumnDTO task, int id) {
        taskRepo.updateTaskByColumn(task, id);
        return "task column updated";
    }

    public int deleteTaskById(int id) {
        return taskRepo.deleteById(id);
    }

    public List<TaskDetailsDTO> getAllTasks() {
        return taskRepo.findAll();
    }

    public TaskData getLastRow() {
        return taskRepo.getLastRow();
    }

}
