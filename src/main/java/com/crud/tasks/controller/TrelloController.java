package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/trello")
@CrossOrigin("*")

public class TrelloController {

    private final TrelloClient trelloClient;

    public TrelloController(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @GetMapping("boards")
    public ResponseEntity<List<TrelloBoardDto>> getTrelloBoards() {
      return ResponseEntity.ok(trelloClient.getTrelloBoards());
    }

    @PostMapping("cards")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}

