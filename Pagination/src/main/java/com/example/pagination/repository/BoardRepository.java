package com.example.pagination.repository;

import com.example.pagination.models.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Long> {
    @Query(value = "select * from tbl_board b limit :limit offset :offset", nativeQuery = true)
    public List<BoardDto> findPageToBoardList(int limit, int offset);
}
