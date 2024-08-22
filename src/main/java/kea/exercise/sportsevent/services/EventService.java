package kea.exercise.sportsevent.services;

import kea.exercise.sportsevent.entities.Event;
import kea.exercise.sportsevent.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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



}
