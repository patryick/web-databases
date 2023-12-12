package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.AbsenceTo;
import pwr.webdatabases.logic.service.AbsenceService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/{studentId}/all")
    @PreAuthorize("#studentId == authentication.principal.id")
    public ResponseEntity<List<AbsenceTo>> getAllByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(absenceService.findAllByStudentId(studentId));
    }

    @PostMapping
    public ResponseEntity<AbsenceTo> postAbsence(@RequestBody AbsenceTo absence) {
        return ResponseEntity.ok(absenceService.saveAbsence(absence));
    }

    @PatchMapping("/{absenceId}")
    public ResponseEntity<AbsenceTo> patchAbsence(@RequestBody AbsenceTo absence, @PathVariable Long absenceId) {
        return ResponseEntity.ok(absenceService.updateAbsence(absence, absenceId));
    }

    @DeleteMapping("/{absenceId}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long absenceId) {

        absenceService.deleteAbsence(absenceId);
        return ResponseEntity.ok().build();
    }
}
