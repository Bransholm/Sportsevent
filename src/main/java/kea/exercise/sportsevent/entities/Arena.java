package kea.exercise.sportsevent.entities;

import jakarta.persistence.*;
import kea.exercise.sportsevent.enums.ArenaShapeEnum;
import kea.exercise.sportsevent.enums.ArenaSurfaceEnum;
import kea.exercise.sportsevent.enums.ArenaTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ArenaTypeEnum type;
    @Enumerated(EnumType.STRING)
    private ArenaShapeEnum shape;
    @Enumerated(EnumType.STRING)
    private ArenaSurfaceEnum surface;
    private int length;
    private int lanes;
}
