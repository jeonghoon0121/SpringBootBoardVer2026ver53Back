package com.abc.boardver52.controller;

import com.abc.boardver52.model.dto.BoardDTO;
import com.abc.boardver52.model.dto.PostDTO;
import com.abc.boardver52.model.dto.CommentDTO;
import com.abc.boardver52.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // ===== Board =====
    // 전체 목록
    @GetMapping("/list")
    public String getAllBoards(Model model) {
        List<BoardDTO> boards = boardService.findAllBoards();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    // 특정 게시판 (숫자만 매칭)
    @GetMapping("/{boardId}")
    public String getBoard(@PathVariable int boardId, Model model) {
        BoardDTO board = boardService.findOneBoard(boardId);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @PostMapping
    public String createBoard(BoardDTO boardDTO) {
        boardService.addBoard(boardDTO);
        return "redirect:/boards/list";
    }

    @PostMapping("/{boardId}/update")
    public String updateBoard(@PathVariable int boardId, BoardDTO boardDTO) {
        boardDTO.setBoardId(boardId);
        boardService.updateBoard(boardDTO);
        return "redirect:/boards/" + boardId;
    }

    @PostMapping("/{boardId}/delete")
    public String deleteBoard(@PathVariable int boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/boards/list";
    }

}