package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.StudentLessonDetailsTo;
import pwr.webdatabases.logic.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{lessonId}/{studentId}")
    @PreAuthorize("#studentId == authentication.principal.id")
    public ResponseEntity<StudentLessonDetailsTo> getStudentLessonDetailsByIdAndLessonId(@PathVariable Long lessonId, @PathVariable Long studentId) {
        return ResponseEntity.ok(studentService.findStudentLessonDetailsByIdAndLessonId(lessonId, studentId));
    }
}
