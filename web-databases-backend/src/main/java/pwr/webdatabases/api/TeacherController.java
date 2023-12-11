package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.TeacherTo;
import pwr.webdatabases.logic.service.TeacherService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherTo> getTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeacherTo>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @PostMapping
    public ResponseEntity<TeacherTo> postTeacher(@RequestBody TeacherTo teacher) {
        return ResponseEntity.ok(teacherService.create(teacher));
    }

    @PutMapping
    public ResponseEntity<TeacherTo> putTeacher(@RequestBody TeacherTo teacher) {
        return ResponseEntity.ok(teacherService.update(teacher));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTeacher(@RequestBody TeacherTo teacher) {
        teacherService.delete(teacher);
        return ResponseEntity.noContent().build();
    }
}
