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

    // 게시글 생성
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

    // 게시글 수정
    @PutMapping("/update/{id}")
    public String reviceboard(@PathVariable("id")Long idx, @ModelAttribute BoardForm form){
        Board revice = boardService.findOne(idx).get();

        System.out.println(revice.getId());

        revice.setTitle(form.getTitle());
        revice.setWriter(form.getWriter());
        revice.setContent(form.getContent());
        revice.setCreatedDate(LocalDateTime.now());
        revice.setDeleteYn('N');
        revice.setHits(form.getHits());

        System.out.println(revice.getTitle());
        
        boardService.update(revice);

        System.out.println(revice.getTitle());

        System.out.println(boardService.findOne(idx).get());
        return "redirect:/";
    }

    // 게시글 삭제
    @DeleteMapping("/delete/{id}")
    public String deleteboard(@PathVariable("id")Long idx){
        System.out.println("id = " + idx +" 번의 삭제 작동에 접근했다.");
        boardService.delete(idx);
        System.out.println("삭제 동작 끝!");

        return "redirect:/";
    }

}
