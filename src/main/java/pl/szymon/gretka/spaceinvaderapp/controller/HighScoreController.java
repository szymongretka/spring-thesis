package pl.szymon.gretka.spaceinvaderapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.entity.Player;
import pl.szymon.gretka.spaceinvaderapp.repository.PlayerRepository;

import java.util.List;

@Controller
@RequestMapping("/highScore")
@CrossOrigin
public class HighScoreController {

    private final PlayerRepository playerRepository;

    public HighScoreController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping(value = "/mobile")
    @ResponseBody
    public List<Player> getTopPlayers() {
        return playerRepository.findFirst10ByOrderByScoreDesc();
    }

    @PostMapping(value = "/mobile")
    @ResponseBody
    public void sendPlayerScore(@RequestBody String playerStr) {
        String nickname = playerStr.substring(0, playerStr.lastIndexOf("&"));
        Long score = Long.valueOf(playerStr.substring(playerStr.lastIndexOf("&") + 1));

        Player player;

        if (playerRepository.findByNickname(nickname) != null) {
            player = playerRepository.findByNickname(nickname);
            if (player.getScore() < score)
                player.setScore(score);
        } else {
            player = new Player();
            player.setNickname(nickname);
            player.setScore(score);
        }

        playerRepository.save(player);
    }

    @GetMapping
    public String getTopPlayers(Model model) {
        model.addAttribute("topPlayers", playerRepository.findFirst10ByOrderByScoreDesc());
        return "topscore/topscore";
    }

}
