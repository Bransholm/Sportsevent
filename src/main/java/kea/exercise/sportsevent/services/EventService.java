package kea.exercise.sportsevent.services;

import kea.exercise.sportsevent.dto.EventRequestDTO;
import kea.exercise.sportsevent.entities.Arena;
import kea.exercise.sportsevent.entities.Discipline;
import kea.exercise.sportsevent.entities.Event;
import kea.exercise.sportsevent.repositories.ArenaRepository;
import kea.exercise.sportsevent.repositories.DisciplineRepository;
import kea.exercise.sportsevent.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ArenaRepository arenaRepository;
    private final DisciplineRepository disciplineRepository;

    public EventService(EventRepository eventRepository, ArenaRepository arenaRepository, DisciplineRepository disciplineRepository) {
        this.eventRepository = eventRepository;
        this.arenaRepository = arenaRepository;
        this.disciplineRepository = disciplineRepository;
    }


    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get all events or filter by discipline
    public List<Event> getEventsByDiscipline(String disciplineName) {
        if ("all".equalsIgnoreCase(disciplineName)) {
            return eventRepository.findAll();
        } else {
            return eventRepository.findByDisciplineName(disciplineName);
        }
    }

    // Create event
    public Event createEvent(EventRequestDTO eventRequestDTO) {
        Arena arena = arenaRepository.findById(eventRequestDTO.getArenaId())
                .orElseThrow(() -> new IllegalArgumentException("Arena not found"));
        Discipline discipline = disciplineRepository.findById(eventRequestDTO.getDisciplineId())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found"));

        checkArenaAvailability(arena, eventRequestDTO.getDate(), eventRequestDTO.getStartTime(), eventRequestDTO.getDurationMinutes());
        checkArenaDisciplineCompatibility(arena, discipline);

        Event event = new Event();
        setEventAttributes(event, eventRequestDTO, arena, discipline);

        return eventRepository.save(event);
    }

    // Update event by id
    public Event updateEvent(int eventId, EventRequestDTO eventRequestDTO) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Arena arena = arenaRepository.findById(eventRequestDTO.getArenaId())
                .orElseThrow(() -> new IllegalArgumentException("Arena not found"));
        Discipline discipline = disciplineRepository.findById(eventRequestDTO.getDisciplineId())
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found"));

        checkArenaAvailability(arena, eventRequestDTO.getDate(), eventRequestDTO.getStartTime(), eventRequestDTO.getDurationMinutes());
        checkArenaDisciplineCompatibility(arena, discipline);

        setEventAttributes(event, eventRequestDTO, arena, discipline);

        return eventRepository.save(event);
    }



    // Business Logic

    // Set event attributes
    public void setEventAttributes(Event event, EventRequestDTO eventRequestDTO, Arena arena, Discipline discipline) {
        event.setParticipantGender(eventRequestDTO.getParticipantGender());
        event.setParticipantAgeGroup(eventRequestDTO.getParticipantAgeGroup());
        event.setMaximumParticipants(eventRequestDTO.getMaxParticipants());
        event.setDate(eventRequestDTO.getDate());
        event.setStartTime(eventRequestDTO.getStartTime());
        event.setDurationMinutes(eventRequestDTO.getDurationMinutes());
        event.setArena(arena);
        event.setDiscipline(discipline);
    }

    // Check for double booking
    public void checkArenaAvailability(Arena arena, LocalDate date, LocalTime startTime, int durationMinutes) {
        LocalTime endTime = startTime.plusMinutes(durationMinutes);

        List<Event> events = eventRepository.findByArenaAndDate(arena, date);
        for (Event existingEvent : events) {
            LocalTime existingStartTime = existingEvent.getStartTime();
            LocalTime existingEndTime = existingStartTime.plusMinutes(existingEvent.getDurationMinutes());

            if ((startTime.isBefore(existingEndTime) && startTime.isAfter(existingStartTime)) ||
                    (endTime.isBefore(existingEndTime) && endTime.isAfter(existingStartTime)) ||
                    startTime.equals(existingStartTime)) {
                throw new IllegalArgumentException("The arena is already booked during the specified time.");
            }
        }
    }

    // Check for arena and discipline match each other
    public void checkArenaDisciplineCompatibility(Arena arena, Discipline discipline) {
        if (!arena.getDisciplines().contains(discipline)) {
            throw new IllegalArgumentException("The discipline does not match the arena's capabilities.");
        }
    }






}
