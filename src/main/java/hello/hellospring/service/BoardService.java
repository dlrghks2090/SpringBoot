package hello.hellospring.service;

import hello.hellospring.domain.Board;
import hello.hellospring.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public List<Board> findBoards(){

        return boardRepository.findAll();
    }
    public Optional<Board> findOne(Long boardId){
        return boardRepository.findById(boardId);
    }

}
