package pl.szymon.gretka.spaceinvaderapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.entity.Player;
import pl.szymon.gretka.spaceinvaderapp.repository.PlayerRepository;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository playerRepository;


    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /*@PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody Player player){
        Player plr = playerRepository.save(player);
        return new ResponseEntity<>(plr, HttpStatus.CREATED);
    }*/

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    /*@GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }*/

    @GetMapping("/all")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "players/allPlayers";
    }


}
