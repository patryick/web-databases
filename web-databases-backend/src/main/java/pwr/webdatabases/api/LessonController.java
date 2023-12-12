package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.service.LessonService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/details/{lessonId}")
    public ResponseEntity<LessonDetailsTo> getLessonsDetailsById(@PathVariable Long lessonId) {
        return ResponseEntity.ok(lessonService.findLessonDetailsById(lessonId));
    }
}
