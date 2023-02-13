package com.gmail.aba.repository;

import com.gmail.aba.data.ColumnData;
import com.gmail.aba.dto.ColumnDetailsDTO;
import lombok.AllArgsConstructor;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class ColumnRepoImpl implements ColumnRepo {

    JdbcTemplate jdbcTemplate;

    @Override
    public int save(ColumnData column) {
        return jdbcTemplate.update("INSERT INTO column1 (column_name, column_order, fk_column) VALUES (?, ?, ?)",
                new Object[] {column.getColumnName(), column.getColumnOrder(), column.getFkColumn()});
    }

    @Override
    public ColumnDetailsDTO findById(int id) {
        try {
            ColumnDetailsDTO columnDetailsDTO = jdbcTemplate.queryForObject("SELECT column_Id, column_name, column_order, board_name FROM column1 LEFT JOIN board b ON b.board_Id = column1.fk_column where column_Id = ?",
                    BeanPropertyRowMapper.newInstance(ColumnDetailsDTO.class), id);

            return columnDetailsDTO;
        } catch (
                IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int updateColumnByName(ColumnData column, int id) {
        return jdbcTemplate.update("UPDATE column1 SET column_name = ? WHERE column_id = ?",
                new Object[] {column.getColumnName(), id});
    }

    @Override
    public int updateColumnByOrder(ColumnData column, int id) {
        return jdbcTemplate.update("UPDATE column1 SET column_order = ? WHERE column_id = ?",
                new Object[] {column.getColumnOrder(), id});
    }

    @Override
    public int deleteColumnById(int id) {
        return jdbcTemplate.update("DELETE FROM column1 WHERE column_id = ?", id);
    }

    @Override
    public List<ColumnDetailsDTO> findAll() {
        return jdbcTemplate.query("SELECT column_Id, column_name, column_order, board_name FROM column1 LEFT JOIN board b ON b.board_Id = column1.fk_column",
                BeanPropertyRowMapper.newInstance(ColumnDetailsDTO.class));
    }

    @Override
    public ColumnData getLastRow() {
        return jdbcTemplate.queryForObject("select * from column1 ORDER BY column_Id DESC LIMIT 1", BeanPropertyRowMapper.newInstance(ColumnData.class) );
    }
}
