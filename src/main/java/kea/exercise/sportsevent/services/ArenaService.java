package kea.exercise.sportsevent.services;

import kea.exercise.sportsevent.entities.Arena;
import kea.exercise.sportsevent.repositories.ArenaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {
    private final ArenaRepository arenaRepository;

    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    // Get all arenas
    public List<Arena> getAllArenas() {
        return arenaRepository.findAll();
    }




}
