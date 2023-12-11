package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.GradeTo;
import pwr.webdatabases.logic.service.GradeService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GradeTo> getGrade(@PathVariable Long id) {
        GradeTo grade = new GradeTo();
        grade.setId(id);
        return ResponseEntity.ok(grade);
    }

    @PostMapping
    public ResponseEntity<GradeTo> postGrade(@RequestBody GradeTo grade) {
        return ResponseEntity.ok(gradeService.create(grade));
    }

    @PutMapping
    public ResponseEntity<GradeTo> putGrade(@RequestBody GradeTo grade) {
        return ResponseEntity.ok(gradeService.update(grade));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteGrade(@RequestBody GradeTo grade) {
        gradeService.delete(grade);
        return ResponseEntity.noContent().build();
    }
}
