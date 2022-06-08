package com.sewoon.board.service;

import com.sewoon.board.Entity.Board;
import com.sewoon.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public Optional<Board> selectById(Long id) {
        return boardRepository.findById(id);
    }
}
