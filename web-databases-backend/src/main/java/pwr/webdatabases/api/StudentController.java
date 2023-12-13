package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.auth.data.model.User;
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

    @GetMapping("/{lessonId}")
    public ResponseEntity<StudentLessonDetailsTo> getStudentLessonDetailsByIdAndLessonId(@PathVariable Long lessonId, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(studentService.findStudentLessonDetailsByIdAndLessonId(lessonId, user.getStudent().getId()));
    }
}
