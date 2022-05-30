package hello.hellospring.service;

import hello.hellospring.domain.Board;
import hello.hellospring.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    public Long join(Board board){
        boardRepository.save(board);
        return board.getId();
    }




}
