package com.example.demo.controller;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    private final CommentRepository commentRepository;

    public BoardController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("comments", commentRepository.findAll());
        model.addAttribute("newComment", new Comment());
        return "board";
    }

    @PostMapping("/board")
    public String postComment(@ModelAttribute Comment newComment) {
        commentRepository.save(newComment);
        return "redirect:/board";
    }
}
