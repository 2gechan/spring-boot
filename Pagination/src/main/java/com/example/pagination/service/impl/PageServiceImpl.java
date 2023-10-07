package com.example.pagination.service.impl;

import com.example.pagination.models.BoardDto;
import com.example.pagination.repository.BoardRepository;
import com.example.pagination.service.PageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    private final BoardRepository boardRepository;
    public PageServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardDto> boardList(int limit, int offset) {
        List<BoardDto> boardList = boardRepository.findPageToBoardList(limit, offset);
        return boardList;
    }

    public int countAll() {
        long longCount = boardRepository.count();
        int count = (int) longCount;
        return count;
    }
}
