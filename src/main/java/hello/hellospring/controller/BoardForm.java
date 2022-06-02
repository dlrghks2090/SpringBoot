package hello.hellospring.controller;

import java.time.LocalDateTime;

public class BoardForm {
    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일


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
