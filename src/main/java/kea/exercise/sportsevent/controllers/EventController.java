package kea.exercise.sportsevent.controllers;

import kea.exercise.sportsevent.entities.Event;
import kea.exercise.sportsevent.services.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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



}
