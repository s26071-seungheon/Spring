package com.example.demo.service;

import com.example.demo.dto.Boarddto;
import com.example.demo.entity.BoardEntity;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Boarddto boarddto) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boarddto);
        boardRepository.save(boardEntity);
    }

    public List<Boarddto> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<Boarddto> boarddtoList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boarddtoList.add(Boarddto.toBoarddto(boardEntity));

        }
        return boarddtoList;
    }
}
