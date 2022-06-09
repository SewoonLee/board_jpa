package com.sewoon.board.mapper;

import com.sewoon.board.data.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    void hello() {
        System.out.println("!!!!!!!" + boardMapper.boardAll());
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

    @Test
    void findById() {
        String pw = "  ";

        if(pw.trim().equals(boardMapper.findPasswordById(1))) System.out.println("!!!!!!!!!");
    }

    @Test
    void boardAll() {
        System.out.println(boardMapper.boardAll());
    }

    @Test
    void testNewBoard() {
        System.out.println(Board.builder().build());
    }

    @Test
    void updateBoard() {

        Board board = Board.builder()
                .id(3)
                .title("이세운이세운이세운")
                .content("ABCDEFGHIJK").build();

        if(board.getPassword() == null){
            System.out.println(boardMapper.updateBoard(board));
        } else {
            System.out.println(boardMapper.updateBoardWithPassword(board));
        }

//        System.out.println(boardMapper.updateBoard(board));

    }

    @Test
    void deleteBoard() {
        System.out.println(boardMapper.deleteBoard(2));
    }

    @Test
    void existsCheckById() {
        System.out.println(boardMapper.findById(1) == null);
    }

    @Test
    void searchBoard() {
        System.out.println(boardMapper.searchBoard("%b%"));
    }

    @Test
    void testFindById() {
        Board board = boardMapper.findById(1);
        if(board != null) System.out.println(board);
        else System.out.println("is not exists");
    }
}