package com.example.skills_project.controller;

import com.example.skills_project.skill.Skill;
import com.example.skills_project.skill.SkillRepository;
import com.example.skills_project.skill.SkillRequestDTO;
import com.example.skills_project.skill.SkillResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skill")
public class SkillController {

    // Injeção de dependência do SkillRepository, que será utilizado para interagir com o banco de dados.
    @Autowired
    private SkillRepository repository;

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity saveSkill(@RequestBody @Valid SkillRequestDTO data){
        // Converte os dados recebidos no DTO para uma entidade Skill.
        Skill skillData = new Skill(data);
        // Salva a nova skill no banco de dados usando o repositório.
        this.repository.save(skillData);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity getAll(){
        // Recupera todas as skills do banco de dados, mapeia para um SkillResponseDTO e retorna como lista.
        List<SkillResponseDTO> skillList = this.repository.findAll().stream()
                .map(SkillResponseDTO::new) // Converte cada Skill em um SkillResponseDTO.
                .toList(); // Converte o Stream para uma lista.
        return ResponseEntity.ok(skillList); // Retorna a lista de DTOs.
    }

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateSkill(@PathVariable Long id, @RequestBody SkillRequestDTO data) {
        // Encontrar a skill pelo ID.
        Skill skillData = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with id: " + id));

        // Atualizar os campos da skill com os dados do DTO.
        skillData.setTitle(data.title());
        skillData.setImage(data.image());

        // Salvar a skill atualizada
        repository.save(skillData);
    }

    // A chave estrangeira não esta configurada como cascata. Isso foi feito para não ocorrer a exclusão automática das referências na tabela user_skill, pois isso pode levar à exclusão em massa de dados relacionados.

    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        try {
            Skill skillData = repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Skill not found with id " + id));

            repository.delete(skillData);
            return ResponseEntity.ok().build(); // Retorna sucesso
        } catch (Exception e) {
            System.err.println("Erro ao deletar a skill: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna erro
        }
    }

}
