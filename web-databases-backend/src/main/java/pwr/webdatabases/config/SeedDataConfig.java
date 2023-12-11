package pwr.webdatabases.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pwr.webdatabases.auth.data.model.User;
import pwr.webdatabases.auth.service.UserService;
import pwr.webdatabases.data.model.ClassEntity;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.data.repository.jpa.ClassJpaRepo;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.data.repository.jpa.TeacherJpaRepo;

@Component
public class SeedDataConfig implements CommandLineRunner {

    @Value("${is.seed.data.config.active}")
    private boolean isActive;
    private final StudentJpaRepo studentJpaRepo;
    private final TeacherJpaRepo teacherJpaRepo;
    private final ClassJpaRepo classJpaRepo;
    private final LessonJpaRepo lessonJpaRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public SeedDataConfig(StudentJpaRepo studentJpaRepo, TeacherJpaRepo teacherJpaRepo, ClassJpaRepo classJpaRepo, LessonJpaRepo lessonJpaRepo, PasswordEncoder passwordEncoder, UserService userService) {
        this.studentJpaRepo = studentJpaRepo;
        this.teacherJpaRepo = teacherJpaRepo;
        this.classJpaRepo = classJpaRepo;
        this.lessonJpaRepo = lessonJpaRepo;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (!isActive) {
            return;
        }

//        if (userRepository.count() == 0) {
//
//            User student = new User();
//            student.setUsername("student");
//            student.setEmail("student@student.com");
//            student.setPassword(passwordEncoder.encode("password"));
//            student.setRole(Role.STUDENT);
//
//            userService.save(student);
//        }

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName("teacher anna");
        teacherJpaRepo.save(teacherEntity);

        ClassEntity classEntity = new ClassEntity();
        classEntity.setName("1a");
        classJpaRepo.save(classEntity);

        LessonEntity lesson1 = new LessonEntity();
        lesson1.setName("math");
        lesson1.setClassEntity(classEntity);
        lesson1.setTeacher(teacherEntity);
        lessonJpaRepo.save(lesson1);

        LessonEntity lesson2 = new LessonEntity();
        lesson2.setName("pe");
        lesson2.setClassEntity(classEntity);
        lessonJpaRepo.save(lesson2);

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("student patrick");
        studentEntity.setClassEntity(classEntity);
        studentJpaRepo.save(studentEntity);

        User student = new User();
        student.setUsername("student");
        student.setEmail("student@student.com");
        student.setPassword(passwordEncoder.encode("password"));
        student.setStudent(studentEntity);
        userService.save(student);

        User teacher = new User();
        teacher.setUsername("teacher");
        teacher.setEmail("teacher@teacher.com");
        teacher.setPassword(passwordEncoder.encode("password"));
        teacher.setTeacher(teacherEntity);
        userService.save(teacher);

    }
}
