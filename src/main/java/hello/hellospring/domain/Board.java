package hello.hellospring.domain;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.StringTokenizer;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    public String getWriter(){
        return writer;
    }
    public void setWriter(String writer){
        this.writer = writer;
    }

    public int getHits(){
        return hits;
    }
    public void setHits(int hits){
        this.hits = hits;
    }

    public char getDeleteYn(){
        return deleteYn;
    }
    public void setDeleteYn(char deleteYn){
        this.deleteYn = deleteYn;
    }

}