package com.abc.board.model.controller;

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
        List<PostDTO> posts = boardService.findAllPosts();
        model.addAttribute("postList", posts);
        return "post/postList";
    }
    @GetMapping("/{postId}")
    public String getPostDetail(@PathVariable int postId, Model model) {
        PostDTO post = boardService.findOnePost(postId);
        List<CommentDTO> comments = boardService.findCommentsByPostId(postId);

        model.addAttribute("post", post);
        model.addAttribute("commentList", comments);
        return "post/postDetail";
    }
    @GetMapping("/add")
    public String showAddPostForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "post/addForm";
    }
    @PostMapping("/add")
    public String createPost(@ModelAttribute PostDTO postDTO) {
        boardService.addPost(postDTO);
        return "redirect:/post";
    }
    @GetMapping("/update")
    public String showUpdatePostForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "post/updateForm";
    }
    @PostMapping("/update")
    public String updatePost(@ModelAttribute PostDTO postDTO) {
        boardService.updatePost(postDTO);
        return "redirect:/post";
    }
    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("post", new PostDTO());
        return "post/deleteForm";
    }
    @PostMapping("/delete")
    public String deletePostByPostId(@ModelAttribute PostDTO postDTO) {
        boardService.deletePost(postDTO);
        return "redirect:/post";
    }
}