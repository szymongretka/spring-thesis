package pl.szymon.gretka.spaceinvaderapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.repository.PlayerRepository;

@Controller
@RequestMapping("/highScore")
public class HighScoreController {

    private final PlayerRepository playerRepository;

    public HighScoreController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public String getTopPlayers(Model model) {
        model.addAttribute("topPlayers", playerRepository.findAllByOrderByScoreDesc());
        return "topscore/topscore";
    }

}
