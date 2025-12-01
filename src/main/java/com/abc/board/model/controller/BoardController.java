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
    @GetMapping("{boardId}")
    public String getBoardDetail(@PathVariable int boardId, Model model) {
        BoardDTO board = boardService.findOneBoard(boardId);
        List<PostDTO> posts = boardService.findPostsByBoardId(boardId);

        model.addAttribute("board", board);
        model.addAttribute("postlist", posts);
        return "board/boardDetail";
    }
    @GetMapping("/add")
    public String showAddBoardForm(Model model) {
        model.addAttribute("board", new BoardDTO());
        return "board/addForm"; // createForm.html로 이동
    }
    @PostMapping("/add")
    public String createBoard(@ModelAttribute BoardDTO board) {
        boardService.addBoard(board); // 서비스에서 DB 저장
        return "redirect:/board"; // 등록 후 목록으로 리다이렉트
    }
    @GetMapping("/update/{boardId}")
    public String showUpdateBoardForm(@PathVariable int boardId, Model model) {
        BoardDTO board = boardService.findOneBoard(boardId);
        model.addAttribute("board", board);
        return "board/updateForm";
    }
    @PostMapping("/update/{boardId}")
    public String updateBoard(@PathVariable int boardId, @ModelAttribute BoardDTO board) {
        board.setBoardId(boardId); // PathVariable로 받은 ID를 DTO에 세팅
        boardService.updateBoard(board);
        return "redirect:/board/" + boardId; // 수정 후 상세 페이지로 이동
    }
    @GetMapping("/delete")
    public String showDeleteForm() {
        return "deleteForm";
    }
    @PostMapping("/delete")
    public String deleteBoardByBoardId(@RequestParam int boardId) {
        boardService.deleteBoard(boardId);
        return "redirect:/board"; // 삭제 후 목록으로 이동
    }
}