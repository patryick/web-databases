package pwr.webdatabases.config;

import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pwr.webdatabases.auth.data.model.User;
import pwr.webdatabases.auth.data.repo.UserJpaRepo;
import pwr.webdatabases.auth.service.UserService;
import pwr.webdatabases.data.model.ClassEntity;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.data.repository.jpa.ClassJpaRepo;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.data.repository.jpa.TeacherJpaRepo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
@Transactional
public class SeedDataConfig implements CommandLineRunner {

    @Value("${is.seed.data.config.active}")
    private boolean isActive;
    private final StudentJpaRepo studentJpaRepo;
    private final TeacherJpaRepo teacherJpaRepo;
    private final ClassJpaRepo classJpaRepo;
    private final LessonJpaRepo lessonJpaRepo;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserJpaRepo userJpaRepo;
    Random random = new Random();
    private static List<String> NAMES = List.of(
        "Patrick", "Hubert", "Anna", "John", "Patricia", "Joe", "Mark", "Michael", "Jack",
        "Ralph", "Franklin", "Trevor", "Barry"
    );
    private static List<String> SURNAMES = List.of("Smith", "Johnson", "Williams", "Jones", "Brown",
        "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas");
    private static List<String> PASSWORDS = List.of("password3", "password1", "password2");
    private static List<String> LESSONS = List.of("math", "physics", "pe", "biology", "chemistry", "history", "english", "german", "religion");
    private static List<String> DAY = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    private List<TeacherEntity> teachers = new LinkedList<>();
    private static List<LocalTime> TIMES = List.of(
        LocalTime.of(8,0),
        LocalTime.of(9,45),
        LocalTime.of(10,40),
        LocalTime.of(11,35),
        LocalTime.of(12,40),
        LocalTime.of(13,35),
        LocalTime.of(14,30)
        );


    public SeedDataConfig(StudentJpaRepo studentJpaRepo, TeacherJpaRepo teacherJpaRepo, ClassJpaRepo classJpaRepo, LessonJpaRepo lessonJpaRepo, PasswordEncoder passwordEncoder, UserService userService, UserJpaRepo userJpaRepo) {
        this.studentJpaRepo = studentJpaRepo;
        this.teacherJpaRepo = teacherJpaRepo;
        this.classJpaRepo = classJpaRepo;
        this.lessonJpaRepo = lessonJpaRepo;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userJpaRepo = userJpaRepo;
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

        ClassEntity firstClassA = new ClassEntity();
        firstClassA.setName("1a");
        classJpaRepo.save(firstClassA);

        for (int i = 0; i < 9; i++) {

            TeacherEntity teacher = new TeacherEntity();
            teacher = teacherJpaRepo.save(teacher);
            teachers.add(teacher);

            User user = new User();
            user.setName(NAMES.get(random.nextInt(NAMES.size() - 1)));
            user.setSurname(SURNAMES.get(random.nextInt(NAMES.size() - 1)));
            user.setEmail(user.getName() + "." + user.getSurname() + i + "@teacher.com");
            user.setUsername("teacher" + user.getName() + i);
            user.setPassword(passwordEncoder.encode("teacher" + user.getName() + i));
            user.setTeacher(teacher);
            userService.save(user);

            teacher.setUser(user);
            teacherJpaRepo.save(teacher);
        }

        for (int i = 0; i < 24; i++) {

            StudentEntity student = new StudentEntity();
            student.setDateOfBirth(LocalDateTime.now());
            student.setClassEntity(firstClassA);
            studentJpaRepo.save(student);

            User user = new User();
            user.setName(NAMES.get(random.nextInt(NAMES.size() - 1)));
            user.setSurname(SURNAMES.get(random.nextInt(NAMES.size() - 1)));
            user.setEmail(user.getName() + "." + user.getSurname() + i + "@student.com");
            user.setUsername(user.getName() + i);
            user.setPassword(passwordEncoder.encode(user.getName() + i));
            user.setStudent(student);
            userService.save(user);

            student.setUser(user);
            studentJpaRepo.save(student);
        }

        for (String day: DAY) {
            for (LocalTime time: TIMES) {

                LessonEntity lesson = new LessonEntity();
                lesson.setLessonDay(day);
                lesson.setName(LESSONS.get(random.nextInt(LESSONS.size() - 1)));
                lesson.setStartTime(time);
                lesson.setEndTime(time.plusMinutes(45));
                lesson.setClassEntity(firstClassA);
                lesson.setTeacher(teachers.get(random.nextInt(teachers.size() - 1)));
                lesson.setLocation("203b");
                lessonJpaRepo.save(lesson);
            }
        }

        userJpaRepo.findAll().forEach(System.out::println);
    }
}
