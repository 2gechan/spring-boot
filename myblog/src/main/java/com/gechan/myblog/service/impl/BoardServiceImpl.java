package com.gechan.myblog.service.impl;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.models.CategoryVO;
import com.gechan.myblog.repository.BoardRepository;
import com.gechan.myblog.repository.CategoryRepository;
import com.gechan.myblog.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    public BoardServiceImpl(BoardRepository boardRepository, CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<BoardDto> boardList() {
        List<BoardDto> boardList = boardRepository.findAll();
        return boardList;
    }

    @Override
    public BoardDto findById(long b_seq) {
        BoardDto dto = boardRepository.findById(b_seq).orElse(null);
        return dto;
    }

    @Override
    public List<CategoryVO> categoryList() {
        List<CategoryVO> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    @Override
    public List<BoardDto> categoryBoardList(String category) {
        long cate = Long.parseLong(category);
        CategoryVO categoryVO;
        categoryVO = categoryRepository.findById(cate).orElse(null);
        if (categoryVO == null) {
            return  null;
        } else {
            List<BoardDto> categoryBoardList = boardRepository.findByCategoryInBoard(categoryVO.getCategory());
            return categoryBoardList;
        }


    }

    @Override
    public BoardDto insert(BoardDto dto) {
        BoardDto newBoard = boardRepository.save(dto);
        CategoryVO category = categoryRepository.findByCategory(dto.getB_category());

         if (category == null) {
             category = new CategoryVO();
             category.setCategory(dto.getB_category());
             categoryRepository.save(category);
         }
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
