package kea.exercise.sportsevent.repositories;

import kea.exercise.sportsevent.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
