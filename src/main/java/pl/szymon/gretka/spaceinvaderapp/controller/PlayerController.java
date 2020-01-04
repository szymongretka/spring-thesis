package pl.szymon.gretka.spaceinvaderapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.entity.Player;
import pl.szymon.gretka.spaceinvaderapp.entity.Spaceship;
import pl.szymon.gretka.spaceinvaderapp.repository.PlayerRepository;
import pl.szymon.gretka.spaceinvaderapp.repository.SpaceshipRepository;
import org.json.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final SpaceshipRepository spaceshipRepository;


    public PlayerController(PlayerRepository playerRepository, SpaceshipRepository spaceshipRepository) {
        this.playerRepository = playerRepository;
        this.spaceshipRepository = spaceshipRepository;
    }

    @PostMapping(value = "/mobile")
    @ResponseBody
    public void addSpaceship(@RequestBody String requestBody) {

        JSONObject jsonObject = new JSONObject(requestBody);

        List<Spaceship> spaceships = new ArrayList<>();

        try {
            JSONArray jsonArray = jsonObject.getJSONArray("ships");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject innerObj = jsonArray.getJSONObject(i);
                String shipName = innerObj.getString("class");
                boolean available = innerObj.getBoolean("available");
                Spaceship spaceship = spaceshipRepository.findByName(shipName);
                if(spaceship == null)
                    spaceship = new Spaceship(shipName, available);
                spaceships.add(spaceship);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String nickname = jsonObject.getString("nickname");
        Player player = playerRepository.findByNickname(nickname);

        if(player == null)
            player = new Player(nickname);

        player.setSpaceships(spaceships);
        playerRepository.save(player);
    }


    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/all")
    public String getAllPlayers(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "players/allPlayers";
    }


}
