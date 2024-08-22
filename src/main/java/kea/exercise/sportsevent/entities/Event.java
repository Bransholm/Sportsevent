package kea.exercise.sportsevent.entities;

import jakarta.persistence.*;
import kea.exercise.sportsevent.enums.ParticipantAgeGroupEnum;
import kea.exercise.sportsevent.enums.ParticipantGenderEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ParticipantGenderEnum participantGender;
    @Enumerated(EnumType.STRING)
    private ParticipantAgeGroupEnum participantAgeGroup;
    private int maximumParticipants;
    private LocalDate date;
    private LocalTime startTime;
    private int durationMinutes;
    @ManyToOne
    private Arena arena;
    @ManyToOne
    private Discipline discipline;

    public Event(ParticipantGenderEnum participantGender, ParticipantAgeGroupEnum participantAgeGroup, int maximumParticipants, LocalDate date, LocalTime startTime, int durationMinutes, Arena arena, Discipline discipline) {
        this.participantGender = participantGender;
        this.participantAgeGroup = participantAgeGroup;
        this.maximumParticipants = maximumParticipants;
        this.date = date;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.arena = arena;
        this.discipline = discipline;
    }
}
