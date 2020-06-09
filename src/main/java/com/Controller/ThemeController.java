package com.Controller;

import com.Exception.ResourceNotFoundException;
import com.Model.Theme;
import com.Repositories.ThemeRepository;
import org.hibernate.annotations.GenerationTime;
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
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepository;

    @GetMapping("/themes")
    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    @GetMapping("/themes/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable(value = "id" ) Integer thCode) throws ResourceNotFoundException
    {
        Theme theme = themeRepository.findById(thCode).orElseThrow(() -> new ResourceNotFoundException("No theme with this id!" + thCode));
        return ResponseEntity.ok().body(theme);
    }

    @PostMapping("/themes")
    public Theme createTheme(@RequestBody Theme theme) {
        if (!themeRepository.existsByThNom(theme.getThNom())) {
            return themeRepository.save(theme);
        }
        return  null;
    }

    @PutMapping("/themes/{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable(value = "id") Integer thCode ,
    @Valid @RequestBody Theme themeDetails) throws ResourceNotFoundException {
        Theme theme = themeRepository.findById(thCode).orElseThrow(
                () -> new ResourceNotFoundException("No theme for this id" + thCode));

        theme.setThNom(themeDetails.getThNom());
        final Theme updatedTheme = themeRepository.save(theme);
        return ResponseEntity.ok(updatedTheme);
    }

    @DeleteMapping("/themes/{id}")
    public Map<String, Boolean> deleteTheme(@PathVariable(value = "id")
                                                           Integer thCode) throws ResourceNotFoundException {
        Theme theme = themeRepository.findById(thCode).orElseThrow(
                () -> new ResourceNotFoundException("No theme for this id" + thCode));
        themeRepository.delete(theme);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;


    }
}
