package com.abc.board.model.dao;


import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.CommentDTO;
import com.abc.board.model.dto.PostDTO;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BoardMapper {
    // ===== Board =====
    List<BoardDTO> findAllBoards();
    BoardDTO findOneBoard(int boardId);

    void addBoard(BoardDTO boardDTO);
    void updateBoard(BoardDTO boardDTO);
    void deleteBoard(int boardId);

    // ===== Post =====
    List<PostDTO> findAllPosts();
    PostDTO findOnePost(int postId);

    void addNewPost(PostDTO postDTO);
    void updatePost(PostDTO postDTO);
    void deletePost(PostDTO postDTO);

    // ===== Comment =====
    List<CommentDTO> findAllComments();
    CommentDTO findOneComment(int commentId);

    void addComment(CommentDTO commentDTO);
    void updateComment(CommentDTO commentDTO);
    void deleteComment(CommentDTO commentDTO);

}
