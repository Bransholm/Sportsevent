package kea.exercise.sportsevent.controllers;

import kea.exercise.sportsevent.dto.EventRequestDTO;
import kea.exercise.sportsevent.entities.Event;
import kea.exercise.sportsevent.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    // Get all events
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get all events by discipline or all events if "all" is specified
    @GetMapping("/by-discipline")
    public List<Event> getAllEventsByDiscipline(@RequestParam String discipline) {
        return eventService.getEventsByDiscipline(discipline);
    }

    // Create event
    @PostMapping
    public Event createEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        return eventService.createEvent(eventRequestDTO);
    }

    // Update event by id
    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable int id, @RequestBody EventRequestDTO eventRequestDTO) {
        return eventService.updateEvent(id, eventRequestDTO);
    }

    // Delete event by id
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Event> deleteOneEvent(@PathVariable int id) {
        return eventService.deleteOneEvent(id);
    }



}
