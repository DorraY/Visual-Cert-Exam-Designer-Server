package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Explication;
import com.Repositories.ExplicationRepository;
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
public class ExplicationController {

    @Autowired
    private ExplicationRepository explicationRepository;

    @GetMapping("/explications")
    public List<Explication> getAllExplications() {
        return explicationRepository.findAll();
    }

    @GetMapping("/explications/{id}")
    public ResponseEntity<Explication> getExplicationById(@PathVariable(value = "id" )
        Integer exCode) throws ResourceNotFoundException {
        Explication explication = explicationRepository.findById(exCode).orElseThrow(() -> new ResourceNotFoundException("No explication with this id!" + exCode));
        return ResponseEntity.ok().body(explication);
    }

    @PostMapping("/explications/")
    public Explication createExplication(@Valid @RequestBody Explication explication) {
        return explicationRepository.save(explication);
    }

    @PutMapping("/explications/{id}")
    public ResponseEntity<Explication> updateExplication(@PathVariable(value = "id") Integer exCode ,
    @Valid @RequestBody Explication explicationDetails) throws ResourceNotFoundException {
        Explication explication = explicationRepository.findById(exCode).orElseThrow(
                () -> new ResourceNotFoundException("No explication for this id" + exCode));
        
        explication.setExQucode(explicationDetails.getExQucode());
        explication.setExTextExplanation(explicationDetails.getExTextExplanation());

        final Explication updatedExplication = explicationRepository.save(explication);
        return ResponseEntity.ok(updatedExplication);
    }

    @DeleteMapping("/explications/{id}")
    public Map<String, Boolean> deleteExplication(@PathVariable(value = "id") Integer exCode) throws ResourceNotFoundException {
        Explication explication = explicationRepository.findById(exCode).orElseThrow(
                () -> new ResourceNotFoundException("No explication for this id" + exCode));
        explicationRepository.delete(explication);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
