package pwr.webdatabases.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pwr.webdatabases.auth.data.model.User;
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

    @GetMapping("/students")
    public ResponseEntity<List<StudentLessonTo>> getScheduleForStudent(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(scheduleService.getScheduleForStudent(user.getStudent().getId()));
    }

    @GetMapping("/teachers")
    public ResponseEntity<List<TeacherLessonTo>> getScheduleForTeacher(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(scheduleService.getScheduleForTeacher(user.getTeacher().getId()));
    }
}
