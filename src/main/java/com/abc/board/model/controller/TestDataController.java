package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.CommentDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestDataController {
    private final BoardService boardService;

    public TestDataController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping // /test
    public String getTest(Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardList", boardDTOS);

        List<PostDTO> postDTOS = boardService.findAllPosts();
        model.addAttribute("postList", postDTOS);

        List<CommentDTO> commentDTOS = boardService.findAllComments();
        model.addAttribute("commentList", commentDTOS);

        return "testData/test";
    }
    @GetMapping("/board")
    public String getBoardTest(Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardList", boardDTOS);
        return "testData/board";
    }
    @GetMapping("/post")
    public String getPostTest(Model model) {
        List<PostDTO> postDTOS=boardService.findAllPosts();
        model.addAttribute("postList",postDTOS);
        return "testData/post";
    }
    @GetMapping("/comment")
    public String getCommentTest(Model model) {
        List<CommentDTO> commentDTOS=boardService.findAllComments();
        model.addAttribute("commentList",commentDTOS);
        return "testData/comment";
    }
}
