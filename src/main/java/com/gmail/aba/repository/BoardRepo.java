package com.gmail.aba.repository;

import com.gmail.aba.data.BoardData;


public interface BoardRepo {
    int save(BoardData boardData);

    int deleteById(int id);

}
