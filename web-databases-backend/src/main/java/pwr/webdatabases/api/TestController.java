package pwr.webdatabases.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.webdatabases.auth.data.model.User;
import pwr.webdatabases.auth.data.repo.UserJpaRepo;
import pwr.webdatabases.data.model.*;
import pwr.webdatabases.data.repository.jpa.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    private GradeJpaRepo gradeJpaRepo;
    private AbsenceJpaRepo absenceJpaRepo;
    private LessonJpaRepo lessonJpaRepo;
    private StudentJpaRepo studentJpaRepo;
    private TeacherJpaRepo teacherJpaRepo;
    private ClassJpaRepo classJpaRepo;
    private final UserJpaRepo userJpaRepo;

    public TestController(GradeJpaRepo gradeJpaRepo, AbsenceJpaRepo absenceJpaRepo, LessonJpaRepo lessonJpaRepo, StudentJpaRepo studentJpaRepo, TeacherJpaRepo teacherJpaRepo, ClassJpaRepo classJpaRepo, UserJpaRepo userJpaRepo) {
        this.gradeJpaRepo = gradeJpaRepo;
        this.absenceJpaRepo = absenceJpaRepo;
        this.lessonJpaRepo = lessonJpaRepo;
        this.studentJpaRepo = studentJpaRepo;
        this.teacherJpaRepo = teacherJpaRepo;
        this.classJpaRepo = classJpaRepo;
        this.userJpaRepo = userJpaRepo;
    }

    @GetMapping("/grades")
    public List<GradeEntity> getGrades() {
        return gradeJpaRepo.findAll();
    }

    @GetMapping("/absences")
    public List<AbsenceEntity> getAbsences() {
        return absenceJpaRepo.findAll();
    }

    @GetMapping("/lessons")
    public List<LessonEntity> getLessons() {
        return lessonJpaRepo.findAll();
    }

    @GetMapping("/students")
    public List<StudentEntity> getStudents() {
        return studentJpaRepo.findAll();
    }

    @GetMapping("/teachers")
    public List<TeacherEntity> getTeachers() {
        return teacherJpaRepo.findAll();
    }

    @GetMapping("/classes")
    public List<ClassEntity> getClasses() {
        return classJpaRepo.findAll();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userJpaRepo.findAll();
    }

}
