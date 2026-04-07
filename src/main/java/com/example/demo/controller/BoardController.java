package com.example.demo.controller;

import org.springframework.ui.Model;
import com.example.demo.dto.Boarddto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(Boarddto boarddto) {
        System.out.println("boarddto = " + boarddto);
        boardService.save(boarddto);
        return "redirect:/board/";
    }
    @GetMapping("/")
    public String findAll(Model model) {
        List<Boarddto> boarddtoList = boardService.findAll();
        model.addAttribute("boardList", boarddtoList);
        return "list";
    }
}
