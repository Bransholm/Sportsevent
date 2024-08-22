package kea.exercise.sportsevent.repositories;

import kea.exercise.sportsevent.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByDisciplineName(String disciplineName);
}
