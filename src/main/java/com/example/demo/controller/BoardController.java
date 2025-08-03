package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    private final CommentRepository commentRepository;

    @Autowired
    public BoardController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("comments", commentRepository.findAll()); // DB에서 댓글 목록 조회
        model.addAttribute("newComment", new Comment());
        return "board";
    }

    @PostMapping("/board")
    public String postComment(@ModelAttribute Comment newComment) {
        commentRepository.save(newComment); // DB에 댓글 저장
        return "redirect:/board";
    }
}