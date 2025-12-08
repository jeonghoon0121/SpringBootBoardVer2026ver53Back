package com.abc.board.model.controller;

import com.abc.board.model.dto.CommentDTO;
import com.abc.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private final BoardService boardService;

    public CommentController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String getCommentList(Model model) {
        List<CommentDTO> commentDTOS = boardService.findAllComments();
        model.addAttribute("commentList", commentDTOS);
        return "comment/commentList";
    }
    @GetMapping("/{commentId}")
    public String getCommentDetail(@PathVariable int commentId, Model model) {
        CommentDTO comments = boardService.findOneComment(commentId);

        model.addAttribute("comment", comments);
        return "comment/commentDetail";
    }
    @GetMapping("/add")
    public String showAddCommentForm(Model model) {
        model.addAttribute("comment", new CommentDTO());
        return "comment/addForm";
    }
    @PostMapping("/add")
    public String createComment(@ModelAttribute CommentDTO commentDTO) {
        boardService.addComment(commentDTO);
        return "redirect:/comment";
    }
    @GetMapping("/update")
    public String showUpdateCommentForm(Model model) {
        model.addAttribute("comment", new CommentDTO());
        return "comment/updateForm";
    }
    @PostMapping("/update")
    public String updateComment(@ModelAttribute CommentDTO commentDTO) {
        boardService.updateComment(commentDTO);
        return "redirect:/comment";
    }
    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("comment", new CommentDTO());
        return "comment/deleteForm";
    }
    @PostMapping("/delete")
    public String deleteComment(@ModelAttribute CommentDTO commentDTO) {
        boardService.deleteComment(commentDTO);
        return "redirect:/comment";
    }


}