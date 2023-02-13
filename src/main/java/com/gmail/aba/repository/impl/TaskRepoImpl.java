package com.gmail.aba.repository.impl;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.TaskDetailsDTO;
import com.gmail.aba.dto.TaskUpdateColumnDTO;
import com.gmail.aba.dto.TaskUpdateDTO;
import com.gmail.aba.dto.TaskUpdateOrderDTO;
import com.gmail.aba.repository.TaskRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Repository
public class TaskRepoImpl implements TaskRepo {

    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(TaskData task) {
        return jdbcTemplate.update("INSERT INTO task (task_name, task_description, task_date, task_order, fk_task) VALUES (?, ?, ?, ?, ?)",
                new Object[] {task.getTaskName(), task.getTaskDescription(), task.getTaskDate(), task.getTaskOrder(), task.getFkTask() }); //LocalDate.now()
    }

    @Override
    public TaskDetailsDTO findById(int id) {
        try {
            TaskDetailsDTO taskDetailsDTO = jdbcTemplate.queryForObject("SELECT task_id, task_name, task_description, task_order, task_date, column_name from task join column1 c on c.column_Id = task.fk_task where task_Id = ?",
                    BeanPropertyRowMapper.newInstance(TaskDetailsDTO.class), id);

            return taskDetailsDTO;
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int updateTask(TaskUpdateDTO task, int id) {
        return jdbcTemplate.update("UPDATE task SET task_name = ?, task_description = ?, task_date = ? WHERE task_id = ?",
                new Object[] {task.getTaskName(), task.getTaskDescription(), task.getTaskDate(), id});
    }

    @Override
    public int updateTaskOrder(TaskUpdateOrderDTO task, int id) {
        return jdbcTemplate.update("UPDATE task SET task_order = ? WHERE task_id = ?",
                new Object[] {task.getTaskOrder(), id});
    }

    @Override
    public int updateTaskColumn(TaskUpdateColumnDTO task, int id) {
        return jdbcTemplate.update("UPDATE task SET fk_task = ? WHERE task_id = ?",
                new Object[] {task.getFkTask(), id});
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM task WHERE task_id = ?", id);
    }

    @Override
    public List<TaskDetailsDTO> findAll() {
        return jdbcTemplate.query("SELECT task_id, task_name, task_description, task_order, task_date, column_name from task join column1 c on c.column_Id = task.fk_task",
                BeanPropertyRowMapper.newInstance(TaskDetailsDTO.class));
    }

    @Override
    public TaskData getLastRow() {
        return jdbcTemplate.queryForObject("select * from task ORDER BY task_Id DESC LIMIT 1", BeanPropertyRowMapper.newInstance(TaskData.class) );
    }

}
