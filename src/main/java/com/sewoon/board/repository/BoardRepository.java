package com.sewoon.board.repository;

import com.sewoon.board.Entity.Board;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface BoardRepository extends Repository<Board, Long> {
    Optional<Board> findById(Long id);
}
