package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/boards")
public class BoardAPIController {

    private final BoardService boardService;

    public BoardAPIController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<BoardDTO>> getBoardList() {
        return ResponseEntity.ok(boardService.findAllBoards());
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> getBoardDetail(@PathVariable int boardId) {
        BoardDTO board = boardService.findOneBoard(boardId);
        return ResponseEntity.ok(board);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createBoard(@RequestBody BoardDTO board) {
        boardService.addBoard(board);
        return ResponseEntity.ok("Board created successfully");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateBoard(@PathVariable int boardId, @RequestBody BoardDTO board) {
        board.setBoardId(boardId);
        boardService.updateBoard(board);
        return ResponseEntity.ok("Board updated successfully");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBoard(@PathVariable int boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.ok("Board deleted successfully");
    }

}
