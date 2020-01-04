package pl.szymon.gretka.spaceinvaderapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymon.gretka.spaceinvaderapp.repository.SpaceshipRepository;

@Controller
@RequestMapping("/ship")
public class SpaceshipController {

    private final SpaceshipRepository spaceshipRepository;

    public SpaceshipController(SpaceshipRepository spaceshipRepository) {
        this.spaceshipRepository = spaceshipRepository;
    }

    @GetMapping
    public String getAllShips(Model model) {
        model.addAttribute("topPlayers", spaceshipRepository.findAll());
        return "ships/ships";
    }

}
