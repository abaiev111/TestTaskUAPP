package com.gmail.aba.repository;
import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;

import java.util.List;

public interface ColumnRepo {
    int save(ColumnData column);
    ColumnDetailsDTO findById(int id);
    int updateColumnByName(ColumnData column, int id);
    int updateColumnByOrder(ColumnData column, int id);
    int deleteColumnById(int id);
    List<ColumnDetailsDTO> findAll();
}
