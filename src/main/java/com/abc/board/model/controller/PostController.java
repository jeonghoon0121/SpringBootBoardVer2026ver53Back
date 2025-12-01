package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.CommentDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final BoardService boardService;

    public PostController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping
    public String getPostList(Model model) {
        List<PostDTO> postDTOS = boardService.findAllPosts();
        model.addAttribute("postList", postDTOS);
        return "post/postList";
    }
    @GetMapping("{postId}")
    public String getPostDetail(@PathVariable int postId, Model model) {
        PostDTO post = boardService.findOnePost(postId);
        List<CommentDTO> comments = boardService.findCommentsByPostId(postId);
        BoardDTO board = boardService.findOneBoard(post.getBoardId());
        model.addAttribute("board", board);
        model.addAttribute("post", post);
        model.addAttribute("commentlist", comments);
        return "post/postDetail";
    }
}