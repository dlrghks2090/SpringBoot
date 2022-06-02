package hello.hellospring.controller;

import hello.hellospring.domain.Board;
import hello.hellospring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String createboard(){
        return "board/boardForm";
    }
    @PostMapping("/board")
    public String addboard(@ModelAttribute BoardForm form){
        Board board = new Board();
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        board.setWriter(form.getWriter());
        board.setHits(0);   //form.getHits()
        board.setDeleteYn('N');
        board.setCreatedDate(LocalDateTime.now());

        boardService.join(board);

        return "redirect:/";
    }

}
