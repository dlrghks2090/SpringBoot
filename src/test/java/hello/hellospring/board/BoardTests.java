package hello.hellospring.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import hello.hellospring.domain.Board;
import hello.hellospring.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {

        // 1. 게시글 파라미터 생성
        Board params = new Board();

        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("도뎡이");
        params.setHits(0);
        params.setDeleteYn('N');


        // 2. 게시글 저장
        boardRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Board entity = boardRepository.findById((long) 1).get();
        assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
        assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
        assertThat(entity.getWriter()).isEqualTo("도뎡이");
    }

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long boardsCount = boardRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        Board entity = boardRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        boardRepository.delete(entity);
    }

}