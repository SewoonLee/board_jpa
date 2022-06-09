package com.sewoon.board.controller;


import com.sewoon.board.data.Board;
import com.sewoon.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {


    @Autowired
    BoardMapper boardMapper;

    @GetMapping("/test")
    public String test() {
        return "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest";
    }

    // password 필수
    @PostMapping("/new")
    public String postBoard(@RequestBody Board board) {
        System.out.println("[post board]");
        System.out.println(board);


        return boardMapper.newBoard(board) ? "등록 성공" : "등록 실패";
    }

    @GetMapping("/{id}")
    public Board findById(@PathVariable("id") int id) {
        Board board = boardMapper.findById(id);
        System.out.println("[get board by id]");
        System.out.println("id: " + id);


        if(board == null) {
            return Board.builder().build();
        }else {
            return board;
        }
    }

    @GetMapping("/all")
    public List<Board> selectAll() {
        System.out.println("[select all]");

        return boardMapper.boardAll();
    }

    @GetMapping("/search/{keyword}")
    public List<Board> searchBoard(@PathVariable("keyword") String keyword) {
        System.out.println("[search]");
        System.out.println("keyword: " + keyword);

        return boardMapper.searchBoard("%"+keyword+"%");
    }


    // id 가 포함된 Board
    // password 체크
    @PutMapping("/update/{password}")
    public String updateBoard(@RequestBody Board board, @PathVariable("password") String password) {
        System.out.println("[update]");
        System.out.println(board);
        System.out.println(password);

        if(boardMapper.findById(board.getId()) == null) return "이미 삭제된 게시물입니다.";

        if (checkPassword(board.getId(), password)) {
            if(board.getPassword() == null){
                System.out.println("    [updateBoard]");
                return boardMapper.updateBoard(board) ? "수정 성공" : "수정 실패";
            } else {
                System.out.println("    [updateBoardWithPassword]");
                return boardMapper.updateBoardWithPassword(board) ? "수정 성공" : "수정 실패";
            }

        } else {
            return "비밀번호가 일치하지 않습니다";
        }

    }

    // password 체크
    @DeleteMapping("/delete/{id}/{password}")
    public String deleteBoard(@PathVariable("id") int id, @PathVariable("password") String password) {
        System.out.println("[delete]");
        System.out.println("id: " + id);
        System.out.println("password: " + password);


        if(boardMapper.findById(id) == null) return "이미 삭제된 게시물입니다.";

        if(checkPassword(id, password)) {
            return boardMapper.deleteBoard(id) ? "삭제 성공" : "삭제 실패";
        } else {
            return "비밀번호가 일치하지 않습니다.";
        }
    }

    public boolean checkPassword(int id, String password) {
        return password.trim().equals(boardMapper.findPasswordById(id));
    }


}
