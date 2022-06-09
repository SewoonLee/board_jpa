package com.sewoon.board.mapper;


import com.sewoon.board.data.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {



    @Select("""
            SELECT *
            FROM board
            WHERE id = #{id}
            """)
    public Board findById(@Param("id") int id);

    @Select("""
            SELECT *
            FROM board
            """)
    public List<Board> boardAll();

    @Select("""
            SELECT *
            FROM board
            WHERE title like #{keyword}
            """)
    public List<Board> searchBoard(@Param("keyword") String keyword);

    @Select("""
            SELECT password
            FROM board
            WHERE id=#{id}
            """)
    public String findPasswordById(@Param("id") int id);


    @Insert("""
            INSERT INTO board(title, content, password)
            VALUES (#{board.title}, #{board.content}, #{board.password})
            """)
    public boolean newBoard(@Param("board") Board board);

    @Update("""
            UPDATE board
            SET title=#{board.title}, content=#{board.content}
            """)
    public boolean updateBoard(@Param("board") Board board);

    @Update("""
            UPDATE board
            SET title=#{board.title}, content=#{board.content}, password=#{board.password}
            """)
    public boolean updateBoardWithPassword(@Param("board") Board board);

    @Delete("""
            DELETE FROM board
            WHERE id=#{id}
            """)
    public boolean deleteBoard(@Param("id") int id);
}
