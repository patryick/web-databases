package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.StudentTo;
import pwr.webdatabases.logic.service.StudentService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentTo> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentTo>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
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
