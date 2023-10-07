package com.example.pagination.service;

import com.example.pagination.models.BoardDto;

import java.util.List;

public interface PageService {
    public List<BoardDto> boardList(int limit, int offset);
    public int countAll();
}
