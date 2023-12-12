package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.AbsenceEntity;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.repository.jpa.AbsenceJpaRepo;
import pwr.webdatabases.data.repository.jpa.GradeJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.logic.mapper.StudentMapper;
import pwr.webdatabases.logic.model.StudentLessonDetailsTo;
import pwr.webdatabases.logic.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentJpaRepo studentJpaRepo;
    private final GradeJpaRepo gradeJpaRepo;
    private final AbsenceJpaRepo absenceJpaRepo;
    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    public StudentServiceImpl(StudentJpaRepo studentJpaRepo, GradeJpaRepo gradeJpaRepo, AbsenceJpaRepo absenceJpaRepo) {
        this.studentJpaRepo = studentJpaRepo;
        this.gradeJpaRepo = gradeJpaRepo;
        this.absenceJpaRepo = absenceJpaRepo;
    }

    @Override
    public StudentLessonDetailsTo findStudentLessonDetailsByIdAndLessonId(Long lessonId, Long studentId) {

        StudentEntity student = studentJpaRepo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student with id: " + studentId + " not found."));
        List<GradeEntity> grades = gradeJpaRepo.findAllByLessonId(lessonId);
        List<AbsenceEntity> absences = absenceJpaRepo.findAllByLessonId(lessonId);
        student.setGrades(grades);
        student.setAbsences(absences);

        return studentMapper.toLessonDetailsTo(student);
    }
}
