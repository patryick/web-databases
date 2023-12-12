package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.GradeDetailsTo;
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

    @PostMapping
    public ResponseEntity<GradeDetailsTo> postGrade(@RequestBody GradeTo grade) {

        return ResponseEntity.ok(gradeService.saveGrade(grade));
    }

    @PatchMapping("/{gradeId}")
    public ResponseEntity<GradeDetailsTo> putGrade(@RequestBody GradeTo grade, @PathVariable Long gradeId) {

        return ResponseEntity.ok(gradeService.updateGrade(grade, gradeId));
    }

    @DeleteMapping("/{gradeId}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long gradeId) {

        gradeService.deleteGrade(gradeId);
        return ResponseEntity.ok().build();
    }
}
