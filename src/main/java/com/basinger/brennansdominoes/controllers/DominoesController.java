package com.basinger.brennansdominoes.controllers;

import com.basinger.brennansdominoes.models.Game;
import com.basinger.brennansdominoes.services.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dominoes")
public class DominoesController {

    @Autowired
    private GameService gameService;


    @GetMapping("/start")
    public ResponseEntity<Game> startGame() {
        return ResponseEntity.ok(gameService.startNewGame());
    }


    @PostMapping("/start")
    public ResponseEntity<Game> startNewGame() {
        return ResponseEntity.ok(gameService.startNewGame());
    }

    // ... other endpoints
}
