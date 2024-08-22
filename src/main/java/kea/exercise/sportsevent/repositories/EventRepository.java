package kea.exercise.sportsevent.repositories;

import kea.exercise.sportsevent.entities.Arena;
import kea.exercise.sportsevent.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByDisciplineName(String disciplineName);
    List<Event> findByArenaAndDate(Arena arena, LocalDate date);
}
