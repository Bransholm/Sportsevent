package kea.exercise.sportsevent.repositories;

import kea.exercise.sportsevent.entities.Arena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArenaRepository extends JpaRepository<Arena, Integer> {
}
