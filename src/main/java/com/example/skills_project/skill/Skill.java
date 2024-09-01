package com.example.skills_project.skill;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "skills")
@Entity(name = "skills")

// em runtime declara os métodos
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Skill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private String description;

    public Skill(SkillRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.description = data.description();

    }
}
