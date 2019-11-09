package pl.szymon.gretka.spaceinvaderapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.entity.Player;
import pl.szymon.gretka.spaceinvaderapp.repository.PlayerRepository;

import java.util.List;

@RestController
@RequestMapping("/highscore")
public class HighscoreController {

    private final PlayerRepository playerRepository;

    public HighscoreController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getAllPlayersByScore() {
        return playerRepository.findAllByOrderByScoreDesc();
    }

}
