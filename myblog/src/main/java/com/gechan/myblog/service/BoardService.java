package com.gechan.myblog.service;

import com.gechan.myblog.models.BoardDto;

import java.util.List;

public interface BoardService {

    public List<BoardDto> boardList();

    public BoardDto insert(BoardDto dto);

    public BoardDto update(BoardDto dto);

    public void delete(long b_seq);

}
