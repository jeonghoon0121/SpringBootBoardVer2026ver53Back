package com.abc.boardver52.model.controller;

import com.abc.boardver52.model.dto.BoardDTO;
import com.abc.boardver52.model.dto.PostDTO;
import com.abc.boardver52.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    private final BoardService boardService;

    public PostController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/add/{boardId}")
    public String showPostAddForm(@PathVariable int boardId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("boardId", boardId);
        return "postAdd";
    }

    @GetMapping("/update/{postId}")
    public String showPostUpdateForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("postId", postId);
        return "postUpdate";
    }

    @GetMapping("/delete/{postId}")
    public String showPostDeleteForm(@PathVariable int postId, Model model) {
        List<BoardDTO> boardDTOS = boardService.findAllBoards();
        model.addAttribute("boardlist", boardDTOS);
        model.addAttribute("postId", postId);
        return "postDelete";
    }

    /* post 추가 */
    @PostMapping("/add/{boardId}")
    public String handlePostAdd(@PathVariable int boardId,
                                @ModelAttribute PostDTO postDTO) {
        postDTO.setBoardId(boardId);
        boardService.addNewPost(postDTO);
        return "redirect:/board/" + boardId;
    }

    /* post 수정 */
    @PostMapping("/update/{postId}")
    public String handlePostUpdate(@PathVariable int postId,
                                   @ModelAttribute PostDTO postDTO) {
        postDTO.setPostId(postId);
        boardService.updatePost(postDTO);
        return "redirect:/post/" + postId;
    }

    /* post 삭제 */
    @PostMapping("/delete/{postId}")
    public String handlePostDelete(@PathVariable int postId,
                                   @ModelAttribute PostDTO postDTO) {
        postDTO.setPostId(postId);
        int boardId = boardService.findOnePost(postDTO.getPostId()).getBoardId(); // 수정된 부분
        boardService.deletePost(postDTO);
        return "redirect:/board/" + boardId;
    }
}