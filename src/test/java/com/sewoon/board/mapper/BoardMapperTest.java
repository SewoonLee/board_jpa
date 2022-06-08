package com.sewoon.board.mapper;

import com.sewoon.board.data.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void hello() {
        System.out.println("!!!!!!!" + boardMapper.hello());
    }

    @Test
    void newBoard() {

        Board board = Board.builder()
                        .title("이세운이세운이세운")
                        .content("ABCDEFGHIJK").build();

        System.out.println("!!!!!");
        System.out.println(board);
        System.out.println(boardMapper.newBoard(board));
    }
}