package com.example.skills_project.controller;

import com.example.skills_project.services.UserSkillService;
import com.example.skills_project.userSkill.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_skills")
public class UserSkillController {

    @Autowired
    private UserSkillService userSkillService;

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserSkillResponseDTO> associateSkillToUser(@RequestBody UserSkillRequestDTO requestDTO) {
        UserSkillResponseDTO userSkillResponseDTO = userSkillService.associateSkillToUser(requestDTO.getSkillId(), requestDTO.getLevel());
        return ResponseEntity.status(HttpStatus.CREATED).body(userSkillResponseDTO);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<UserSkillResponseDTO>> getUserSkills() {
        List<UserSkillResponseDTO> userSkills = userSkillService.getUserSkillsByUser();
        return ResponseEntity.ok(userSkills);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<UserSkill> getUserSkillById(@PathVariable Long id) {
        UserSkill userSkill = userSkillService.getUserSkillById(id);
        return ResponseEntity.ok(userSkill);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<UserSkillUpdateDTO> updateUserSkill(
            @PathVariable Long id,
            @RequestBody UpdateUserSkillRequest request) {
        UserSkillUpdateDTO updatedUserSkill = userSkillService.updateUserSkill(id, request.getLevel());
        return ResponseEntity.ok(updatedUserSkill);
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSkill(@PathVariable Long id) {
        userSkillService.deleteUserSkill(id);
        return ResponseEntity.noContent().build();
    }
}
