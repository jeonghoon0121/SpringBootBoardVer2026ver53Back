package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
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

    /* comment 추가 */
    @GetMapping("/add/{postId}")
    public String showCommentAddForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("postId", postId);
        return "commentAdd";
    }

    @PostMapping("/add/{postId}")
    public String handleCommentAdd(@PathVariable int postId,
                                   @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setPostId(postId);
        boardService.addNewComment(commentDTO);
        return "redirect:/post/" + postId;
    }

    /* comment 수정 */
    @PostMapping("/update/{commentId}")
    public String handleCommentUpdate(@PathVariable int commentId,
                                      @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setCommentId(commentId);
        int postId = boardService.findOneComment(commentId).getPostId(); // 수정된 부분
        boardService.updateComment(commentDTO);
        return "redirect:/post/" + postId;
    }

    /* comment 삭제 */
    @PostMapping("/delete/{commentId}")
    public String handleCommentDelete(@PathVariable int commentId,
                                      @ModelAttribute CommentDTO commentDTO) {
        commentDTO.setCommentId(commentId);
        int postId = boardService.findOneComment(commentId).getPostId(); // 수정된 부분
        boardService.deleteComment(commentDTO);
        return "redirect:/post/" + postId;
    }
}