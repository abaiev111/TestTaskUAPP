package com.gmail.aba.repository;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.*;

import java.util.List;

public interface TaskRepo {

    int save(TaskData task);
    TaskDetailsDTO findById(int id);
    int updateTask(TaskUpdateDTO task, int id);
    int updateTaskByOrder(TaskUpdateOrderDTO task, int id);
    int updateTaskByColumn(TaskUpdateColumnDTO task, int id);
    int deleteById(int id);

    List<TaskDetailsDTO> findAll();

    public TaskData getLastRow();

}
