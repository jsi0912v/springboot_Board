package com.board.service;

import com.board.dto.BoardDTO;
import com.board.entity.BoardEntity;
import com.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// DTO -> Entity 변환 (DB저장) (Entity Class)
// Entity -> DTO 변환 (DB조회) (DTO Class)

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll() {
        // Repository에서 Entity 객체로 전달하여 DTO 객체로 변환하여 Controller로 던져줌.
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        //List에 담아서 전달.
        List<BoardDTO> boardDTOList = new ArrayList<>();

        //boardEntity로 꺼내온 데이터를 for문을 이용하여 하나씩 DTO로 변환하여 저장.
        for(BoardEntity boardEntity: boardEntityList){
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }
}
