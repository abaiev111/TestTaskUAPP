package com.gmail.aba.controller;

import com.gmail.aba.data.BoardData;
import com.gmail.aba.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {
    BoardService boardService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public BoardData create(@RequestBody BoardData boardData) {
        boardService.createBoard(boardData);
        return boardData;
    }
}
