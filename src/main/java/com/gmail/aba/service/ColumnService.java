package com.gmail.aba.service;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import com.gmail.aba.repository.ColumnRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColumnService {
    ColumnRepoImpl columnRepo;

    public int createColumn(ColumnData columnData) {
        return columnRepo.save(columnData);
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

}
