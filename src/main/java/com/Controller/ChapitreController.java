package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Chapitre;
import com.Model.Examen;
import com.Model.Question;
import com.Repositories.ChapitreRepository;
import com.Repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ChapitreController {

    @Autowired
    private ChapitreRepository chapitreRepository;

    @Autowired
    private QuestionController questionController;

    @GetMapping("/chapters")
    public List<Chapitre> getAllChapters() {
        return chapitreRepository.findAll();
    }

    @GetMapping("/chapters/{id}")
    public ResponseEntity<Chapitre> getChapterById(@PathVariable(value = "id" )
        Integer chCode) throws ResourceNotFoundException {
        Chapitre chapitre = chapitreRepository.findById(chCode).orElseThrow(() -> new ResourceNotFoundException("No chapter with this id!" + chCode));
        return ResponseEntity.ok().body(chapitre);
    }

    @PostMapping("/chapters")
    public Chapitre createChapter(@Valid @RequestBody Chapitre chapitre) {
        if (!chapitreRepository.existsByChNom(chapitre.getChNom())) {
            return chapitreRepository.save(chapitre);
        }
        return  null;


    }

    @PutMapping("/chapters/{id}")
    public ResponseEntity<Chapitre> updateChapter(@PathVariable(value = "id") Integer chCode ,
    @Valid @RequestBody Chapitre chapitreDetails) throws ResourceNotFoundException {
        Chapitre chapitre = chapitreRepository.findById(chCode).orElseThrow(
                () -> new ResourceNotFoundException("No chapter for this id" + chCode));

        chapitre.setChCode(chapitreDetails.getChCode());

        final Chapitre updatedChapitre = chapitreRepository.save(chapitre);
        return ResponseEntity.ok(updatedChapitre);
    }

    @DeleteMapping("/chapters/{id}")
    public Map<String, Boolean> deleteChapter(@PathVariable(value = "id") Integer chCode) throws ResourceNotFoundException {
        Chapitre chapitre = chapitreRepository.findById(chCode).orElseThrow(
                () -> new ResourceNotFoundException("No chapter for this id" + chCode));
        chapitreRepository.delete(chapitre);
        List<Question> allQuestions = questionController.getAllQuestions();
        for (Question question: allQuestions) {
            if (question.getQuChCode().getChCode().equals(chCode)) {
                questionController.deleteQuestion(question.getQuCode());
            }
        }


        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
