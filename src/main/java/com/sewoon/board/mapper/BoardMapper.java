package com.sewoon.board.mapper;

import com.sewoon.board.data.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("""
            SELECT *
            FROM board
            """)
    public List<Board> hello();


    @Insert("""
            INSERT INTO board(title, content, passwd)
            VALUES (#{board.title}, #{board.content}, #{board.passwd})
            """)@Options(useGeneratedKeys = true, keyProperty = "board.id")
    public long newBoard(@Param("board") Board board);

}
