package com.Controller;

import com.Model.Question;
import com.Repositories.ExamenRepository;
import com.Exception.ResourceNotFoundException;
import com.Model.Examen;
import com.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ExamenController {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private QuestionController questionController;

    @GetMapping("/exams")

    public List<Examen> getAllExams() {
        return examenRepository.findAll();
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<Examen> getExamById(@PathVariable(value = "id" )
        Integer exId) throws ResourceNotFoundException {
        Examen examen = examenRepository.findById(exId).orElseThrow(() -> new ResourceNotFoundException("No exam with this id!" + exId));
        return ResponseEntity.ok().body(examen);
    }

    @PostMapping("/exams")
    public Examen createExam(@Valid @RequestBody Examen examen) {
        return examenRepository.save(examen);
    }

    @PutMapping("/exams/{id}")
    public ResponseEntity<Examen> updateExam(@PathVariable(value = "id") Integer exId ,
    @Valid @RequestBody Examen examenDetails) throws ResourceNotFoundException {
        Examen examen = examenRepository.findById(exId).orElseThrow(
                () -> new ResourceNotFoundException("No exam for this id" + exId));

        examen.setExNom(examenDetails.getExNom());
        examen.setExScore(examenDetails.getExScore());
        examen.setExThCode(examenDetails.getExThCode());
        examen.setExTime(examenDetails.getExTime());
        final Examen updatedExamen = examenRepository.save(examen);
        return ResponseEntity.ok(updatedExamen);
    }

    @DeleteMapping("/exams/{id}")
    public Map<String, Boolean> deleteExam(@PathVariable(value = "id") Integer exId) throws ResourceNotFoundException {
        Examen examen = examenRepository.findById(exId).orElseThrow(
                () -> new ResourceNotFoundException("No exam for this id" + exId));
        List<Question> allQuestions = questionController.getAllQuestions();
        for (Question question: allQuestions) {
            if (question.getExCode().getExId().equals(exId)) {
                questionController.deleteQuestion(question.getQuCode());
            }
        }
        examenRepository.delete(examen);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
