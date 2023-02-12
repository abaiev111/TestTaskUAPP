package com.gmail.aba.repository;

import com.gmail.aba.data.BoardData;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@AllArgsConstructor
@Repository
public class BoardRepoImpl implements BoardRepo{

    JdbcTemplate jdbcTemplate;

    @Override
    public int save(BoardData boardData) {
        return jdbcTemplate.update("INSERT INTO board (board_name) VALUES (?)",
                new Object[] {boardData.getBoardName()});
    }
}
