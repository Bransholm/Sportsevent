package kea.exercise.sportsevent.controllers;

import kea.exercise.sportsevent.entities.Arena;
import kea.exercise.sportsevent.services.ArenaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/arenas")
public class ArenaController {

    private final ArenaService arenaService;

    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }


    // Get all arenas
    @GetMapping
    public List<Arena> getAllArenas() {
        return arenaService.getAllArenas();
    }
}
