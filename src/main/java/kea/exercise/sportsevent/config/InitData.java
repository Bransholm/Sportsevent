package kea.exercise.sportsevent.config;

import kea.exercise.sportsevent.entities.Discipline;
import kea.exercise.sportsevent.repositories.ArenaRepository;
import kea.exercise.sportsevent.repositories.DisciplineRepository;
import kea.exercise.sportsevent.repositories.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

        private final ArenaRepository arenaRepository;
        private final EventRepository eventRepository;
        private  final DisciplineRepository disciplineRepository;

        //private final Discipline run100m;
        //private final Discipline run1500m;
        //private final Discipline hurdless400m;
        //private final Discipline longjump;
        //private final Discipline highjump;
        //private final Discipline shotput;
        //private final Discipline butterfly50m;
        //private final Discipline breaststroke100m;
        //private final Discipline freestyle200m;

        public InitData(ArenaRepository arenaRepository, EventRepository eventRepository, DisciplineRepository disciplineRepository) {
            this.arenaRepository = arenaRepository;
            this.eventRepository = eventRepository;
            this.disciplineRepository = disciplineRepository;
        }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Init data is created");
    }

    // Create disciplines
}
