package com.basinger.brennansdominoes.controllers;

import com.basinger.brennansdominoes.models.Game;
import com.basinger.brennansdominoes.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dominoes")
public class DominoesController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public ResponseEntity<Game> startNewGame() {
        return ResponseEntity.ok(gameService.startNewGame());
    }

    // ... other endpoints
}
