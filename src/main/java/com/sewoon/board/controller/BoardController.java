package com.sewoon.board.controller;


import com.sewoon.board.data.Board;
import com.sewoon.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {


    @Autowired
    BoardMapper boardMapper;


    // password 필수
    @PostMapping("/new")
    public int postBoard(@RequestBody Board board) {
        System.out.println("[post board]");
        System.out.println(board);


        return boardMapper.newBoard(board);
    }

    @GetMapping("/all")
    public List<Board> selectAll() {
        System.out.println("[select all]");

        return boardMapper.boardAll();
    }

    @GetMapping("/search")
    public List<Board> searchBoard() {
        System.out.println("[search]");

        return null;
    }


    // id 가 포함된 Board
    @PutMapping("/update/{password}")
    public boolean updateBoard(@RequestBody Board board, @PathVariable("password") String password) {
        System.out.println("[update]");
        System.out.println(board);
        System.out.println(password);


        return boardMapper.updateBoard(board, password);
    }

    @DeleteMapping("/delete/{id}/{password}")
    public boolean deleteBoard(@PathVariable("id") int id, @PathVariable("password") String password) {
        System.out.println("[delete]");
        System.out.println(id);
        System.out.println(password);

        return boardMapper.deleteBoard(id, password);
    }

    public boolean checkPassword(int id, String password) {


        return Objects.equals(boardMapper.findById(id), password);
    }


}
