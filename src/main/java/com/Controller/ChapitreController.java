package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Chapitre;
import com.Repositories.ChapitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:9090")
@RestController
@RequestMapping("/api/v1")
public class ChapitreController {

    @Autowired
    private ChapitreRepository chapitreRepository;

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

    @PostMapping("/chapters/")
    public Chapitre createChapter(@Valid @RequestBody Chapitre chapitre) {
        return chapitreRepository.save(chapitre);
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
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
