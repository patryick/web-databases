package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.service.LessonService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<LessonTo>> getLessonsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(lessonService.findAllByStudentId(studentId));
    }

    @GetMapping("/teachers/{teacherId}")
    public ResponseEntity<List<LessonTo>> getLessonsByTeacherId(@PathVariable Long teacherId) {
        return ResponseEntity.ok(lessonService.findAllByTeacherId(teacherId));
    }

    @PostMapping
    public ResponseEntity<LessonTo> postLesson(@RequestBody LessonTo lesson) {
        return ResponseEntity.ok(lessonService.create(lesson));
    }

    @PutMapping
    public ResponseEntity<LessonTo> putLesson(@RequestBody LessonTo lesson) {
        return ResponseEntity.ok(lessonService.update(lesson));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLesson(@RequestBody LessonTo lesson) {
        lessonService.delete(lesson);
        return ResponseEntity.noContent().build();
    }
}
