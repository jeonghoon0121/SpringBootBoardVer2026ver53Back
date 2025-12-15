package com.abc.board.service;

import com.abc.board.model.dao.BoardMapper;
import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.CommentDTO;
import com.abc.board.model.dto.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    // ===== Board =====
    public List<BoardDTO> findAllBoards() {
        return mapper.findAllBoards();
    }

    public BoardDTO findOneBoard(int boardId) {
        return mapper.findOneBoard(boardId);
    }

    @Transactional
    public void addBoard(BoardDTO boardDTO) {
        mapper.addBoard(boardDTO);
    }

    @Transactional
    public void updateBoard(BoardDTO boardDTO) {
        mapper.updateBoard(boardDTO);
    }

    @Transactional
    public void deleteBoard(BoardDTO boardDTO) {
        mapper.deleteBoard(boardDTO);
    }

    // ===== Post =====
    public List<PostDTO> findAllPosts() {
        return mapper.findAllPosts();
    }

    public PostDTO findOnePost(int postId) {
        return mapper.findOnePost(postId);
    }

    public List<PostDTO> findPostsByBoardId(int boardId) {
        List<PostDTO> result = new ArrayList<>();
        for (PostDTO post : findAllPosts()) {
            if (post.getBoardId() == boardId) {
                result.add(post);
            }
        }
        return result;
    }

    @Transactional
    public void addPost(PostDTO postDTO) {
        mapper.addPost(postDTO);
    }

    @Transactional
    public void updatePost(PostDTO postDTO) {
        postDTO.setUpdatedAt(java.time.LocalDateTime.now());
        mapper.updatePost(postDTO);
    }

    @Transactional
    public void deletePost(PostDTO postDTO) {
        mapper.deletePost(postDTO);
    }

    // ===== Comment =====
    public List<CommentDTO> findAllComments() {
        return mapper.findAllComments();
    }

    public CommentDTO findOneComment(int commentId) {
        return mapper.findOneComment(commentId);
    }

    public List<CommentDTO> findCommentsByPostId(int postId) {
        List<CommentDTO> result = new ArrayList<>();
        for (CommentDTO comment : findAllComments()) {
            if (comment.getPostId() == postId) {
                result.add(comment);
            }
        }
        return result;
    }

    @Transactional
    public void addComment(CommentDTO commentDTO) {
        mapper.addComment(commentDTO);
    }

    @Transactional
    public void updateComment(CommentDTO commentDTO) {
        mapper.updateComment(commentDTO);
    }

    @Transactional
    public void deleteComment(CommentDTO commentDTO) {
        mapper.deleteComment(commentDTO);
    }
}