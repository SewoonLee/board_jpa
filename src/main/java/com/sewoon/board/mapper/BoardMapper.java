package com.sewoon.board.mapper;


import com.sewoon.board.data.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("""
            SELECT password
            FROM board
            WHRER id=#{id}
            """)
    public String findById(@Param("id") int id);

    @Select("""
            SELECT *
            FROM board
            """)
    public List<Board> boardAll();


    @Insert("""
            INSERT INTO board(title, content, password)
            VALUES (#{board.title}, #{board.content}, #{board.password})
            """)
    public int newBoard(@Param("board") Board board);

    @Update("""
            UPDATE board
            SET title=#{board.title}, content=#{board.content}, password=#{board.password}
            WHERE password=#{password}
            """)
    public boolean updateBoard(@Param("board") Board board, @Param("password") String password);

    @Delete("""
            DELETE FROM board
            WHERE id=#{id}
            AND password=#{password}
            """)
    public boolean deleteBoard(@Param("id") int id, @Param("password") String password);
}
