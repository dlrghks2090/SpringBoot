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

    // 게시글 생성
    public Long join(Board board){
        boardRepository.save(board);
        return board.getId();
    }

    // 게시글 정보 조회
    public List<Board> findBoards(){

        return boardRepository.findAll();
    }

    // 게시글 상세 정보 조회
    public Optional<Board> findOne(Long boardId){
        return boardRepository.findById(boardId);
    }

    // 게시글 수정
    public void update(Board revice){
        System.out.println(revice.getId());
        System.out.println(revice.getTitle());
        boardRepository.findById(revice.getId());
        System.out.println(revice.getTitle());
        return ;
    }

    // 게시글 삭제
    public void delete(Long idx){
        System.out.println("삭제 작동에 접근했다.");
        boardRepository.deleteById(idx);
        System.out.println("삭제 작동 완료.");
        return ;
    }

}
