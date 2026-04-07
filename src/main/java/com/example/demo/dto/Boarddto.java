package com.example.demo.dto;

import com.example.demo.entity.BoardEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString

public class Boarddto {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private String boardCreatedAt;

    private String dateFormat(LocalDateTime date) {
        if(date==null)
            return null;

        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public static Boarddto toBoarddto(BoardEntity boardEntity) {
        Boarddto boarddto = new Boarddto();
        boarddto.setId(boardEntity.getId());
        boarddto.setBoardWriter(boardEntity.getBoardWriter());
        boarddto.setBoardTitle(boarddto.getBoardTitle());
        boarddto.setBoardPass(boardEntity.getBoardPass());
        boarddto.setBoardContents(boardEntity.getBoardContents());
        boarddto.setBoardHits(boardEntity.getBoardHits());
        boarddto.setBoardCreatedAt(boarddto.dateFormat(boardEntity.getCreatedAt()));
        return boarddto;
    }
}
