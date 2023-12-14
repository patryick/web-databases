package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.AbsenceEntity;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.logic.model.AbsenceDetailsTo;
import pwr.webdatabases.logic.model.AbsenceTo;
import pwr.webdatabases.logic.model.StudentAbsenceTo;
import pwr.webdatabases.logic.model.StudentGradeTo;

import java.util.List;

@Mapper
public interface AbsenceMapper {

    AbsenceMapper INSTANCE = Mappers.getMapper(AbsenceMapper.class);

    @Mapping(target = "teacherName", source = "absence.lesson.teacher.user.name")
    @Mapping(target = "teacherSurname", source = "absence.lesson.teacher.user.surname")
    @Mapping(target = "lessonName", source = "absence.lesson.name")
    StudentAbsenceTo toStudent(AbsenceEntity absence);
    AbsenceDetailsTo toTo(AbsenceEntity absence);
    AbsenceEntity toEntity(AbsenceTo absence);
    default List<AbsenceDetailsTo> toToList(List<AbsenceEntity> absences) {
        return absences.stream().map(INSTANCE::toTo).toList();
    }

    default StudentEntity mapStudent(Long id) {

        if (null == id) {
            return null;
        }
        StudentEntity student = new StudentEntity();
        student.setId(id);

        return student;
    }

    default LessonEntity mapLesson(Long id) {

        if (null == id) {
            return null;
        }
        LessonEntity lesson = new LessonEntity();
        lesson.setId(id);

        return lesson;
    }
}
