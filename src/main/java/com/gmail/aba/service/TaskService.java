package com.gmail.aba.service;

import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.TaskDetailsDTO;
import com.gmail.aba.dto.TaskUpdateColumnDTO;
import com.gmail.aba.dto.TaskUpdateDTO;
import com.gmail.aba.dto.TaskUpdateOrderDTO;
import com.gmail.aba.repository.impl.TaskRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepoImpl taskRepo;

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

    public String updateTaskOrder(TaskUpdateOrderDTO task, int id) {
        taskRepo.updateTaskOrder(task, id);
        return "task order updated";
    }

    public String updateTaskColumn(TaskUpdateColumnDTO task, int id) {
        taskRepo.updateTaskColumn(task, id);
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
