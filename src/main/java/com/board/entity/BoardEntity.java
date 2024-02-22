package com.board.entity;

import com.board.dto.BoardDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

//DB 테이블 역할을 하는 클래스
@Entity
@Getter
@Setter
@Table(name="board_table") //Entity에서 정의한 내용으로 DB에 Table 생성 Table어노테이션으로 table 이름 설정
public class BoardEntity extends BaseEntity {
    @Id//pk 컬럼 지정. 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment ( 자동 증가 )
    private Long id;

    @Column(length = 20, nullable = false) // 크기 20, Not null 지정
    private String boardWriter;

    @Column // default 크기 255, null 가능 ,unique 옵션도 가능.
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 500)
    private String boardContents;

    @Column
    private int boardHits; //조회수

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){

        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);

        return boardEntity;
    }
}
