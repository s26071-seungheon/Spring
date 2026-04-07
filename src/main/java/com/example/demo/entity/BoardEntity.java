package com.example.demo.entity;

import com.example.demo.dto.Boarddto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board_table_2025")
public class BoardEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String boardWriter;

    @Column
    private String boardPass;

    @Column
    private String boardTitle;

    @Column
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(Boarddto boarddto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.boardWriter = boarddto.getBoardWriter();
        boardEntity.boardPass = boarddto.getBoardPass();
        boardEntity.boardTitle = boarddto.getBoardTitle();
        boardEntity.boardContents = boarddto.getBoardContents();
        boardEntity.boardHits=0;
        return  boardEntity;
    }
}
