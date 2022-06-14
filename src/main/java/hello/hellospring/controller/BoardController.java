package hello.hellospring.controller;

import hello.hellospring.domain.Board;
import hello.hellospring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BoardController {
    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    // 게시글 리스트 페이지
    @GetMapping("/list")
    public String openBoardList(Model model){

        List<Board> boards = boardService.findBoards();
        model.addAttribute("boards", boards);

        return "board/list";
    }

    // 게시글 등록 페이지
    @GetMapping("/board")
    public String createboard(){
        return "board/boardForm";
    }

    // 게시글 리스트 상세보기
    @GetMapping("/view/{id}")
    public String openBoardList(@PathVariable("id")Long idx, Model model){
        model.addAttribute("board", boardService.findOne(idx).get());
        return "board/view";
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
