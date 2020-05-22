package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Choix;
import com.Repositories.ChoixRepository;
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
public class ChoixController {

    @Autowired
    private ChoixRepository choixRepository;

    @GetMapping("/choices")
    public List<Choix> getAllChoixs() {
        return choixRepository.findAll();
    }

    @GetMapping("/choices/{id}")
    public ResponseEntity<Choix> getChoixById(@PathVariable(value = "id" )
        Integer choixCode) throws ResourceNotFoundException {
        Choix choix = choixRepository.findById(choixCode).orElseThrow(() -> new ResourceNotFoundException("No choice with this id!" + choixCode));
        return ResponseEntity.ok().body(choix);
    }

    @PostMapping("/choices/")
    public Choix createChoix(@Valid @RequestBody Choix choix) {
        return choixRepository.save(choix);
    }

    @PutMapping("/choices/{id}")
    public ResponseEntity<Choix> updateChoix(@PathVariable(value = "id") Integer choixCode ,
    @Valid @RequestBody Choix choixDetails) throws ResourceNotFoundException {
        Choix choix = choixRepository.findById(choixCode).orElseThrow(
                () -> new ResourceNotFoundException("No choix for this id" + choixCode));

        choix.setChCorrect(choixDetails.getChCorrect());
        choix.setChText(choixDetails.getChText());

        final Choix updatedChoix = choixRepository.save(choix);
        return ResponseEntity.ok(updatedChoix);
    }

    @DeleteMapping("/choices/{id}")
    public Map<String, Boolean> deleteChoix(@PathVariable(value = "id") Integer choixCode) throws ResourceNotFoundException {
        Choix choix = choixRepository.findById(choixCode).orElseThrow(
                () -> new ResourceNotFoundException("No choice for this id" + choixCode));
        choixRepository.delete(choix);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
