package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Question;
import com.Repositories.QuestionRepository;
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
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable(value = "id" )
        Integer quCode) throws ResourceNotFoundException {
        Question question = questionRepository.findById(quCode).orElseThrow(() -> new ResourceNotFoundException("No question with this id!" + quCode));
        return ResponseEntity.ok().body(question);
    }

    @PostMapping("/questions/")
    public Question createChapter(@Valid @RequestBody Question question) {
        return questionRepository.save(question);
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateChapter(@PathVariable(value = "id") Integer quCode ,
    @Valid @RequestBody Question questionDetails) throws ResourceNotFoundException {
        Question question = questionRepository.findById(quCode).orElseThrow(
                () -> new ResourceNotFoundException("No question for this id" + quCode));

        question.setOrdre(questionDetails.getOrdre());
        question.setChCode(questionDetails.getChCode());
        question.setExCode(questionDetails.getExCode());
        question.setQuText(questionDetails.getQuText());

        final Question updatedQuestion = questionRepository.save(question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/questions/{id}")
    public Map<String, Boolean> deleteChapter(@PathVariable(value = "id") Integer quCode) throws ResourceNotFoundException {
        Question question = questionRepository.findById(quCode).orElseThrow(
                () -> new ResourceNotFoundException("No question for this id" + quCode));
        questionRepository.delete(question);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
