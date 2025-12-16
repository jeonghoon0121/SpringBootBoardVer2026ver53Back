package com.abc.board.model.controller;

import com.abc.board.model.dto.CommentDTO;
import com.abc.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/comments")
public class CommentRestfulController {
    private final BoardService boardService;

    public CommentRestfulController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 모든 댓글(Comment) 목록 조회
    // 요청: GET /api/comments
    // 응답: 200 OK + CommentDTO 리스트(JSON)
    @GetMapping
    public ResponseEntity<List<CommentDTO>> getCommentList() {
        List<CommentDTO> comments = boardService.findAllComments();
        return ResponseEntity.ok(comments);
    }

    // 특정 댓글(Comment) 수정
    // 요청: PUT /api/comments/{commentId}
    // 입력: URL 경로에서 commentId, 본문에 CommentDTO(JSON)
    // 응답: 200 OK + 수정된 CommentDTO(JSON)
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable int commentId, @RequestBody CommentDTO commentDTO) {
        commentDTO.setCommentId(commentId);
        boardService.updateComment(commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    // 특정 댓글(Comment) 삭제
    // 요청: DELETE /api/comments/{commentId}
    // 입력: URL 경로에서 commentId
    // 응답: 204 No Content
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> commentPost(@PathVariable int commentId) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(commentId);
        boardService.deleteComment(commentDTO);
        return ResponseEntity.noContent().build();
    }
}