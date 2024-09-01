package com.example.skills_project.skill;

public record SkillResponseDTO(Long id, String title, String image, String description) {
    public SkillResponseDTO(Skill skill){
        this(skill.getId(), skill.getTitle(), skill.getImage(), skill.getDescription());
    }
}
