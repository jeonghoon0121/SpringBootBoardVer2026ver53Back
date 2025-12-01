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
@RequestMapping("")
public class HomeController {
    private final BoardService boardService;

    public HomeController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping({"", "/", "/home", "/home/"})
    public String BoardHome(Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);
        return "index";
    }

}