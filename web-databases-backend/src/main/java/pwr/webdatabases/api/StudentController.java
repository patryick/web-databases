package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.StudentTo;
import pwr.webdatabases.logic.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentTo> postStudent(@RequestBody StudentTo student) {
        return ResponseEntity.ok(studentService.create(student));
    }

    @PutMapping
    public ResponseEntity<StudentTo> putStudent(@RequestBody StudentTo student) {
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStudent(@RequestBody StudentTo student) {
        studentService.delete(student);
        return ResponseEntity.noContent().build();
    }
}
