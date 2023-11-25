package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
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
