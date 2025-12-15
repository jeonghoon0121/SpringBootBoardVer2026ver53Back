package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping
    public String getBoardList(Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardList", boardDTOS);
        return "board/boardList";
    }
    @GetMapping("/{boardId}")
    public String getBoardDetail(@PathVariable int boardId, Model model) {
        BoardDTO board = boardService.findOneBoard(boardId);
        List<PostDTO> posts = boardService.findPostsByBoardId(boardId);

        model.addAttribute("board", board);
        model.addAttribute("postList", posts);
        return "board/boardDetail";
    }
    @GetMapping("/add")
    public String showAddBoardForm(Model model) {
        model.addAttribute("board", new BoardDTO());
        return "board/addForm";
    }
    @PostMapping("/add")
    public String createBoard(@ModelAttribute BoardDTO board) {
        boardService.addBoard(board);
        return "redirect:/board";
    }
    @GetMapping("/update")
    public String showUpdateBoardForm(Model model) {
        model.addAttribute("board", new BoardDTO());
        return "board/updateForm";
    }
    @PostMapping("/update")
    public String updateBoard(@ModelAttribute BoardDTO board) {
        boardService.updateBoard(board);
        return "redirect:/board/";
    }
    @GetMapping("/delete")
    public String showDeleteForm(Model model) {
        model.addAttribute("board", new BoardDTO());
        return "board/deleteForm";
    }
    @PostMapping("/delete")
    public String deleteBoardByBoardId(@ModelAttribute BoardDTO board) {
        boardService.deleteBoard(board);
        return "redirect:/board";
    }
}