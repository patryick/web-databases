package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.TeacherLessonDetailsTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;
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
    public ResponseEntity<List<StudentLessonTo>> getLessonsByStudentId(@PathVariable Long studentId) {
        return ResponseEntity.ok(lessonService.findAllByStudentId(studentId));
    }

    @GetMapping("/teachers/{teacherId}")
    public ResponseEntity<List<TeacherLessonTo>> getLessonsByTeacherId(@PathVariable Long teacherId) {
        return ResponseEntity.ok(lessonService.findAllByTeacherId(teacherId));
    }

    @GetMapping("/details/{lessonId}")
    public ResponseEntity<TeacherLessonDetailsTo> getLessonsDetailsById(@PathVariable Long lessonId) {
        return ResponseEntity.ok(lessonService.findDetailsById(lessonId));
    }
}
