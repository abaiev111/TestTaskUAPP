package com.gmail.aba.service;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.repository.impl.ColumnRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColumnService {
    private ColumnRepoImpl columnRepo;

    public void createColumn(ColumnData columnData) {
        columnRepo.save(columnData);
    }

    public ColumnDetailsDTO getColumnById(int id) {
        return columnRepo.findById(id);
    }

    public String updateColumnName(ColumnData column, int id) {
        columnRepo.updateColumnName(column, id);
        return "Column updated";
    }

    public String updateColumnOrder(ColumnData column, int id) {
        columnRepo.updateColumnOrder(column, id);
        return "Column order updated";
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
