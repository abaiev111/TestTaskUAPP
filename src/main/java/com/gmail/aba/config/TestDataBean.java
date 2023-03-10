package com.gmail.aba.config;

import com.gmail.aba.data.BoardData;
import com.gmail.aba.service.BoardService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TestDataBean {

    private BoardService boardService;

    @PostConstruct
    public void fillData() {
        boardService.createBoard(new BoardData(1L, "myBoard"));
    }

    @PreDestroy
    public void destroy() {
        boardService.deleteById(1);
    }
}
