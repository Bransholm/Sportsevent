package kea.exercise.sportsevent.config;

import kea.exercise.sportsevent.entities.Arena;
import kea.exercise.sportsevent.entities.Discipline;
import kea.exercise.sportsevent.entities.Event;
import kea.exercise.sportsevent.enums.*;
import kea.exercise.sportsevent.repositories.ArenaRepository;
import kea.exercise.sportsevent.repositories.DisciplineRepository;
import kea.exercise.sportsevent.repositories.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Component
public class InitData implements CommandLineRunner {

        private final ArenaRepository arenaRepository;
        private final EventRepository eventRepository;
        private  final DisciplineRepository disciplineRepository;

        private Discipline run100m;
        private Discipline run1500m;
        private Discipline hurdless400m;
        private Discipline longjump;
        private Discipline highjump;
        private Discipline shotput;
        private Discipline butterfly50m;
        private Discipline breaststroke100m;
        private Discipline freestyle200m;

        private Arena track1;
        private Arena field1;
        private Arena pool1;

        public InitData(ArenaRepository arenaRepository, EventRepository eventRepository, DisciplineRepository disciplineRepository) {
            this.arenaRepository = arenaRepository;
            this.eventRepository = eventRepository;
            this.disciplineRepository = disciplineRepository;
        }

    @Override
    public void run(String... args) {
        createDisciplines();
        createArenas();
        createEvents();
        System.out.println("Init data is created");
    }

    // Create disciplines
    private void createDisciplines() {
        run100m = new Discipline("100m Run");
        run1500m = new Discipline("1500m Run");
        hurdless400m = new Discipline("400m Hurdles");
        longjump = new Discipline("Long Jump");
        highjump = new Discipline("High Jump");
        shotput = new Discipline("Shot Put");
        butterfly50m = new Discipline("50m Butterfly");
        breaststroke100m = new Discipline("100m Breaststroke");
        freestyle200m = new Discipline("200m Freestyle");

        disciplineRepository.save(run100m);
        disciplineRepository.save(run1500m);
        disciplineRepository.save(hurdless400m);
        disciplineRepository.save(longjump);
        disciplineRepository.save(highjump);
        disciplineRepository.save(shotput);
        disciplineRepository.save(butterfly50m);
        disciplineRepository.save(breaststroke100m);
        disciplineRepository.save(freestyle200m);
    }

    // Create arenas
    private void createArenas() {
        // Track1 - Oval, Tartan surface, 3 disciplines
        track1 = new Arena("Track1", ArenaTypeEnum.Track, ArenaShapeEnum.Oval, ArenaSurfaceEnum.Tartan, 400, 8,
                Arrays.asList(run100m, run1500m, hurdless400m));
        arenaRepository.save(track1);

        // Field1 - Rectangle, Grass surface, 3 disciplines
        field1 = new Arena("Field1", ArenaTypeEnum.Field, ArenaShapeEnum.Rectangle, ArenaSurfaceEnum.Grass, 100, 0,
                Arrays.asList(longjump, highjump, shotput));
        arenaRepository.save(field1);

        // Pool1 - Rectangle, Water surface, 3 disciplines
        pool1 = new Arena("Pool1", ArenaTypeEnum.Pool, ArenaShapeEnum.Rectangle, ArenaSurfaceEnum.Water, 50, 8,
                Arrays.asList(butterfly50m, breaststroke100m, freestyle200m));
        arenaRepository.save(pool1);
    }

    // Create events
    private void createEvents() {
        // Track1 Events
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(9, 0), 60, track1, run100m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(10, 0), 60, track1, run100m));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(11, 0), 60, track1, run1500m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(12, 0), 60, track1, run1500m));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(13, 0), 60, track1, hurdless400m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(14, 0), 60, track1, hurdless400m));

        // Field1 Events
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(9, 0), 60, field1, longjump));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(10, 0), 60, field1, longjump));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(11, 0), 60, field1, highjump));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(12, 0), 60, field1, highjump));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(13, 0), 60, field1, shotput));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(14, 0), 60, field1, shotput));

        // Pool1 Events
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(9, 0), 60, pool1, butterfly50m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Junior, 8, LocalDate.now(), LocalTime.of(10, 0), 60, pool1, butterfly50m));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(11, 0), 60, pool1, breaststroke100m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Adult, 8, LocalDate.now(), LocalTime.of(12, 0), 60, pool1, breaststroke100m));
        eventRepository.save(new Event(ParticipantGenderEnum.Male, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(13, 0), 60, pool1, freestyle200m));
        eventRepository.save(new Event(ParticipantGenderEnum.Female, ParticipantAgeGroupEnum.Senior, 8, LocalDate.now(), LocalTime.of(14, 0), 60, pool1, freestyle200m));

    }

}
