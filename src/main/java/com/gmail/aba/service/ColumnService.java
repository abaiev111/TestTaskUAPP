package com.gmail.aba.service;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.data.TaskData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.repository.ColumnRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColumnService {
    ColumnRepoImpl columnRepo;

    public boolean createColumn(ColumnData columnData) {
        if (columnData.getColumnName() != null && columnData.getColumnOrder() != null) {
            columnRepo.save(columnData);
        }
        return true;
    }

    public ColumnDetailsDTO getColumnById(int id) {
        return columnRepo.findById(id);
    }

    public String updateColumnByName(ColumnData column, int id) {
        columnRepo.updateColumnByName(column, id);
        return "Column updated";
    }

    public String updateColumnByOrder(ColumnData column, int id) {
        columnRepo.updateColumnByOrder(column, id);
        return "Column updated";
    }

    public int deleteColumnById(int id) {
        return columnRepo.deleteColumnById(id);
    }

    public List<ColumnDetailsDTO> getAllColumn() {
        return columnRepo.findAll();
    }

    public ColumnData getLastRow() {
        return columnRepo.getLastRow();
    }



}
