package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;
import pwr.webdatabases.logic.service.ScheduleService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/students/{studentId}")
    @PreAuthorize("#studentId == authentication.principal.id")
    public ResponseEntity<List<StudentLessonTo>> getScheduleForStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(scheduleService.getScheduleForStudent(studentId));
    }

    @GetMapping("/teachers/{teacherId}")
    @PreAuthorize("#teacherId == authentication.principal.id")
    public ResponseEntity<List<TeacherLessonTo>> getScheduleForTeacher(@PathVariable Long teacherId) {
        return ResponseEntity.ok(scheduleService.getScheduleForTeacher(teacherId));
    }
}
