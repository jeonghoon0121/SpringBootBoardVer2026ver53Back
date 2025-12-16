package com.abc.board.model.controller;

import com.abc.board.model.dto.BoardDTO;
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

    // 모든 게시글(Post) 목록 조회
    // 요청: GET /api/posts
    // 응답: 200 OK + PostDTO 리스트(JSON)
    @GetMapping
    public ResponseEntity<List<PostDTO>> getPostList() {
        List<PostDTO> posts = boardService.findAllPosts();
        return ResponseEntity.ok(posts);
    }

    // 특정 게시글(Post) 수정
    // 요청: PUT /api/posts/{postId}
    // 입력: URL 경로에서 postId, 본문에 PostDTO(JSON)
    // 응답: 200 OK + 수정된 PostDTO(JSON)
    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable int postId, @RequestBody PostDTO postDTO) {
        postDTO.setPostId(postId);
        boardService.updatePost(postDTO);
        return ResponseEntity.ok(postDTO);
    }

    // 특정 게시글(Post) 삭제
    // 요청: DELETE /api/posts/{postId}
    // 입력: URL 경로에서 postId
    // 응답: 204 No Content
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable int postId) {
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postId);
        boardService.deletePost(postDTO);
        return ResponseEntity.noContent().build();
    }

    // 특정 게시글(Post)의 댓글(Comment) 목록 조회
    // 요청: GET /api/posts/{postId}/comments
    // 입력: URL 경로에서 postId
    // 응답: 200 OK + CommentDTO 리스트(JSON)
    @GetMapping("/{postId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByPost(@PathVariable int postId) {
        List<CommentDTO> comments = boardService.findCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    // 특정 게시글(Post)에 새 댓글(Comment) 생성
    // 요청: POST /api/posts/{postId}/comments
    // 입력: URL 경로에서 postId, 본문에 CommentDTO(JSON)
    // 응답: 201 Created + 생성된 CommentDTO(JSON)
    @PostMapping("/{postId}")
    public ResponseEntity<CommentDTO> createComment(@PathVariable int postId, @RequestBody CommentDTO commentDTO) {
        commentDTO.setPostId(postId);
        boardService.addComment(commentDTO);
        return ResponseEntity.status(201).body(commentDTO);
    }
}