
package com.abc.board.model.controller;

import com.abc.board.model.dto.CommentDTO;
import com.abc.board.model.dto.PostDTO;
import com.abc.board.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/posts")
public class PostRestfulController {

    private final BoardService boardService;

    public PostRestfulController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 전체 게시글 조회
    @GetMapping
    public ResponseEntity<List<PostDTO>> getPostList() {
        List<PostDTO> posts = boardService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

}
