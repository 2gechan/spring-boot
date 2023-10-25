package com.gechan.myblog.repository;

import com.gechan.myblog.models.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardDto, Long> {
}
