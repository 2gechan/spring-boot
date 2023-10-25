package com.gechan.myblog.service.impl;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.repository.BoardRepository;
import com.gechan.myblog.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public List<BoardDto> boardList() {
        List<BoardDto> boardList = boardRepository.findAll();
        return boardList;
    }

    @Override
    public BoardDto insert(BoardDto dto) {
        BoardDto newBoard = boardRepository.save(dto);
        return newBoard;
    }

    @Override
    public BoardDto update(BoardDto dto) {
        return null;
    }

    @Override
    public void delete(long b_seq) {
        boardRepository.deleteById(b_seq);
    }
}
