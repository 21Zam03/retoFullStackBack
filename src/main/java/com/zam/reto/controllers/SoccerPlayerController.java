package com.zam.reto.controllers;

import com.zam.reto.entities.SoccerPlayerEntity;
import com.zam.reto.services.SoccerPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/soccer_players")
public class SoccerPlayerController {
    @Autowired
    private SoccerPlayerService soccerPlayerService;

    @GetMapping("/{id}")
    public ResponseEntity<SoccerPlayerEntity> getClient(@PathVariable(value = "id") Integer clientId) {
        return new ResponseEntity<>(soccerPlayerService.getSoccerPlayer(clientId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<SoccerPlayerEntity>> listSoccerPlayers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(soccerPlayerService.listSoccerPlayers(page, size), HttpStatus.OK);
    }
}
