package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/boards")   // 복수형 boards 사용
public class BoardRestfulController {

    private final BoardService boardService;

    public BoardRestfulController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 모든 게시판(Board) 목록 조회
    // 요청: GET /api/boards
    // 응답: 200 OK + BoardDTO 리스트(JSON)
    @GetMapping
    public ResponseEntity<List<BoardDTO>> getBoardList() {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        return ResponseEntity.ok(boardDTOS);
    }

    // 새 게시판(Board) 생성
    // 요청: POST /api/boards
    // 입력: BoardDTO(JSON)
    // 응답: 201 Created + 생성된 BoardDTO(JSON)
    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO board) {
        boardService.addBoard(board);
        return ResponseEntity.status(201).body(board);
    }

    // 특정 게시판(Board) 수정
    // 요청: PUT /api/boards/{boardId}
    // 입력: URL 경로에 boardId, 본문에 BoardDTO(JSON)
    // 응답: 200 OK + 수정된 BoardDTO(JSON)
    @PutMapping("/{boardId}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable int boardId, @RequestBody BoardDTO board) {
        board.setBoardId(boardId);
        boardService.updateBoard(board);
        return ResponseEntity.ok(board);
    }

    // 특정 게시판(Board) 삭제
    // 요청: DELETE /api/boards/{boardId}
    // 응답: 204 No Content
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int boardId) {
        BoardDTO board = new BoardDTO();
        board.setBoardId(boardId);
        boardService.deleteBoard(board);
        return ResponseEntity.noContent().build();
    }

    // 특정 게시판(Board)의 게시글(Post) 목록 조회
    // 요청: GET /api/boards/{boardId}
    // 입력: URL 경로에서 boardId
    // 응답: 200 OK + PostDTO 리스트(JSON)
    @GetMapping("/{boardId}")
    public ResponseEntity<List<PostDTO>> getPostsByBoard(@PathVariable int boardId) {
        List<PostDTO> posts = boardService.findPostsByBoardId(boardId);
        return ResponseEntity.ok(posts);
    }

    // 특정 게시판(Board)에 새 게시글(Post) 생성
    // 요청: POST /api/boards/{boardId}
    // 입력: URL 경로에서 boardId, 본문에 PostDTO(JSON)
    // 응답: 201 Created + 생성된 PostDTO(JSON)
    @PostMapping("/{boardId}")
    public ResponseEntity<PostDTO> createPost(@PathVariable int boardId, @RequestBody PostDTO postDTO) {
        postDTO.setBoardId(boardId);
        boardService.addPost(postDTO);
        return ResponseEntity.status(201).body(postDTO);
    }
}