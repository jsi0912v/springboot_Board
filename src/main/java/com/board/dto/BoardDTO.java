package com.board.dto;

import com.board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor //기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자.
// DTO(Data Transfer Object
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits; //조회수
    private LocalDateTime boardCreateTime;
    private LocalDateTime boardUpdateTime;

    public BoardDTO(Long id, String boardWriter, String boardTitle, int boardHits, LocalDateTime boardCreateTime) {
        this.id = id;
        this.boardWriter = boardWriter;
        this.boardTitle = boardTitle;
        this.boardHits = boardHits;
        this.boardCreateTime = boardCreateTime;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreateTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdateTime(boardEntity.getUpdateTime());

        return boardDTO;
    }
}
