package com.example.pagination.controller;

import com.example.pagination.models.BoardDto;
import com.example.pagination.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    private final PageService pageService;

    public HomeController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("hello")
    public void hello() {
        log.debug("서버 연결 확인");
    }

    @GetMapping("board")
    public List<BoardDto> getBoards(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "5") int size) {
        log.debug("게시판 리스트 요청");
        int offset = page * size;
        int limit = size;
        return pageService.boardList(limit, offset);

    }

    @GetMapping("count")
    public int count() {
        log.debug("게시물 개수 요청");
        int count = pageService.countAll();
        return count;
    }
}
