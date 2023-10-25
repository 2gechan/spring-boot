package com.gechan.myblog.controller;

import com.gechan.myblog.models.BoardDto;
import com.gechan.myblog.service.BoardService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {

    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("board")
    public String board(Model model) {

        List<BoardDto> boardList = boardService.boardList();
        model.addAttribute("BOARDLIST", boardList);
        model.addAttribute("BODY", "BOARD");
        return "home";
    }

    @GetMapping("board/write")
    public String board_write(Model model) {

        model.addAttribute("BODY", "BOARD_WRITE");
        return "home";
    }

    @PostMapping("board/write")
    public String board_write(BoardDto dto, Model model) {
        boardService.insert(dto);

        return "redirect:/board";
    }
}
