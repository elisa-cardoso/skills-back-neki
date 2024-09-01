package com.example.skills_project.userSkill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSkillResponseDTO {
    private Long id;
    private Long skillId;
    private String userLogin;
    private String skillName;
    private Integer level;
    private String imageUrl;
    private String description;

    public UserSkillResponseDTO(Long id, Long skillId, String userLogin, String skillName, Integer level, String imageUrl, String description) {
        this.id = id;
        this.skillId = skillId;
        this.userLogin = userLogin;
        this.skillName = skillName;
        this.level = level;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

