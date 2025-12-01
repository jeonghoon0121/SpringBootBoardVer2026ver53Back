package com.abc.boardver52.model.controller;

import com.abc.boardver52.model.dto.BoardDTO;
import com.abc.boardver52.model.dto.CommentDTO;
import com.abc.boardver52.model.dto.PostDTO;
import com.abc.boardver52.service.BoardService;
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
        List<PostDTO> postDTOS = boardService.findAllPosts();
        List<CommentDTO> commentDTOS = boardService.findAllComments();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("postlist", postDTOS);
        model.addAttribute("commentlist", commentDTOS);
        return "home";
    }

    @GetMapping("test")
    public String TestHomeBoard() {
        return "index";
    }

    @GetMapping("board/{boardId}")
    public String getBoardList(@PathVariable int boardId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        BoardDTO board = boardService.findOneBoard(boardId); // 수정된 부분
        List<PostDTO> posts = boardService.findPostsByBoardId(boardId);

        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("board", board);
        model.addAttribute("postlist", posts);
        return "boardlist";
    }

    @GetMapping("post/{postId}")
    public String getPostDetail(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        PostDTO post = boardService.findOnePost(postId); // 수정된 부분
        List<CommentDTO> comments = boardService.findCommentsByPostId(postId);

        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("post", post);
        model.addAttribute("commentlist", comments);
        return "postDetail";
    }
}