package kea.exercise.sportsevent.dto;

import kea.exercise.sportsevent.enums.ParticipantAgeGroupEnum;
import kea.exercise.sportsevent.enums.ParticipantGenderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class EventRequestDTO {
    private ParticipantGenderEnum participantGender;
    private ParticipantAgeGroupEnum participantAgeGroup;
    private int maxParticipants;
    private LocalDate date;
    private LocalTime startTime;
    private int durationMinutes;
    private int arenaId;
    private int disciplineId;
}
