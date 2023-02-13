package com.gmail.aba.service;

import com.gmail.aba.data.BoardData;
import com.gmail.aba.repository.impl.BoardRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepoImpl boardRepo;

    public int createBoard(BoardData boardData) {
        return boardRepo.save(boardData);
    }

    public int deleteById(int id) {
        return boardRepo.deleteById(id);
    }

}
