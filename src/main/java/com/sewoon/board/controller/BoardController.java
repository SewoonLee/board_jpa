package com.sewoon.board.controller;


import com.sewoon.board.Entity.Board;
import com.sewoon.board.mapper.BoardMapper;
import com.sewoon.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @Autowired
    BoardMapper boardMapper;

    @GetMapping("/{id}")
    public Map<String, Object> selectBoardById(@PathVariable("id") long id) {
        Map<String, Object> response = new HashMap<>();

        Optional<Board> oBoard = boardService.selectById(id);
        if(oBoard.isPresent()) {
            response.put("result", "SUCCESS");
            response.put("Board", oBoard.get());
        }else {
            response.put("result", "FAIL");
            response.put("reason", "일치하는 게시글이 없습니다.");
        }

        return response;
    }

//    @GetMapping("/all")
//    public List<Board> selectAll() {
//        return boardMapper.hello();
//    }
//
//    @GetMapping("/search")
//    public List<Board> searchBoard() {
//
//        return null;
//    }
//
//    @PostMapping("/new")
//    public boolean postBoard(@RequestBody Board board) {
////        boardMapper
//        return true;
//    }
//
//    @PutMapping("/update")
//    public boolean updateBoard() {
//
//        return true;
//    }
//
//    @DeleteMapping("/delete")
//    public boolean deleteBoard() {
//
//        return true;
//    }


}
