package kea.exercise.sportsevent.entities;

import jakarta.persistence.*;
import kea.exercise.sportsevent.enums.ArenaShapeEnum;
import kea.exercise.sportsevent.enums.ArenaSurfaceEnum;
import kea.exercise.sportsevent.enums.ArenaTypeEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @ManyToMany
    private List<Discipline> disciplines;

    public Arena(String name, ArenaTypeEnum type, ArenaShapeEnum shape, ArenaSurfaceEnum surface, int length, int lanes, List<Discipline> disciplines) {
        this.name = name;
        this.type = type;
        this.shape = shape;
        this.surface = surface;
        this.length = length;
        this.lanes = lanes;
        this.disciplines = disciplines;
    }
}
