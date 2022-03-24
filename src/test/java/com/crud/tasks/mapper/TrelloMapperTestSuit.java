package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuit {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        List<TrelloListDto> listDto = new ArrayList<>();
        listDto.add(new TrelloListDto("1", "test list1", true));
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("11", "test1", listDto));
        //When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(trelloBoardDto);
        //Then
        assertEquals("11", boards.get(0).getId());
        assertEquals("test1", boards.get(0).getName());
        assertEquals("11", boards.get(0).getId());
        assertEquals("1", boards.get(0).getLists().get(0).getId());
        assertEquals(1, boards.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        List<TrelloList> list = new ArrayList<>();
        list.add(new TrelloList("1", "test list1", true));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("11", "test1", list));
        //When
        List<TrelloBoardDto> boardsDto = trelloMapper.mapToBoardsDto(trelloBoard);
        //Then
        assertEquals("11", boardsDto.get(0).getId());
        assertEquals("test1", boardsDto.get(0).getName());
        assertEquals("11", boardsDto.get(0).getId());
        assertEquals("1", boardsDto.get(0).getLists().get(0).getId());
        assertEquals(1, boardsDto.get(0).getLists().size());
    }

    @Test
    void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "list 1", false));
        trelloListDto.add(new TrelloListDto("2", "list 2", true));
        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDto);
        //Then
        assertEquals(2, trelloList.size());
        assertEquals("2", trelloList.get(1).getId());
        assertEquals("list 2", trelloList.get(1).getName());
        assertEquals(true, trelloList.get(1).isClosed());
    }

    @Test
    void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "list 1", false));
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        //Then
        assertEquals(1, trelloList.size());
        assertEquals("1", trelloList.get(0).getId());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Test task", trelloCardDto.getName());
        assertEquals("Test Description", trelloCardDto.getDescription());
        assertEquals("top", trelloCardDto.getPos());
        assertEquals("test_id", trelloCardDto.getListId());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task1",
                "Test Description1",
                "top",
                "test_id1"
        );
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("Test task1", trelloCard.getName());
        assertEquals("Test Description1", trelloCard.getDescription());
        assertEquals("top", trelloCard.getPos());
        assertEquals("test_id1", trelloCard.getListId());
    }
}
