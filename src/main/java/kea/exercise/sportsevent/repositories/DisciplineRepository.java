package kea.exercise.sportsevent.repositories;

import kea.exercise.sportsevent.entities.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
