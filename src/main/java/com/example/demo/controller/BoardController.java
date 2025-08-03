package com.example.demo.controller;

import com.example.demo.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {

    private final List<Comment> comments = new ArrayList<>();

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("comments", comments);
        model.addAttribute("newComment", new Comment());
        return "board";
    }

    @PostMapping("/board")
    public String postComment(@ModelAttribute Comment newComment) {
        comments.add(newComment);
        return "redirect:/board";
    }
}