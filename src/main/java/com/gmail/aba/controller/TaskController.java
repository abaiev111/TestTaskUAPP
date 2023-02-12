package com.gmail.aba.controller;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.*;
import com.gmail.aba.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/task")
public class TaskController {

    TaskService taskService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskData create(@RequestBody TaskData task) {
        taskService.createTask(task);
        return taskService.getLastRow();
    }

    @GetMapping("/{id}")
    public TaskDetailsDTO getTask(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/update/{id}")
    public String updateTask(@RequestBody TaskUpdateDTO task, @PathVariable int id) {
        return taskService.updateTask(task, id);

    }

    @PutMapping("/update/order/{id}")
    public String updateTaskByOrder(@RequestBody TaskUpdateOrderDTO task, @PathVariable int id) {
        return taskService.updateTaskByOrder(task, id);
    }

    @PutMapping("/update/column/{id}")
    public String updateTaskByColumn(@RequestBody TaskUpdateColumnDTO task, @PathVariable int id) {
        return taskService.updateTaskByColumn(task, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTaskById(@PathVariable int id) {
        taskService.deleteTaskById(id);

        return "Deleted";
    }

    @GetMapping("/getAll")
    public List<TaskDetailsDTO> getAllTasks() {

        List<TaskDetailsDTO> sortedList = taskService.getAllTasks().stream()
                .sorted(Comparator.comparingInt(TaskDetailsDTO::getTaskOrder))
                .collect(Collectors.toList());

        return sortedList;

    }



}