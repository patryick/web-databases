package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.AbsenceEntity;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.logic.model.AbsenceDetailsTo;
import pwr.webdatabases.logic.model.AbsenceTo;

import java.util.List;

@Mapper
public interface AbsenceMapper {

    AbsenceMapper INSTANCE = Mappers.getMapper(AbsenceMapper.class);

    AbsenceDetailsTo toTo(AbsenceEntity absence);
    AbsenceEntity toEntity(AbsenceTo absence);
    List<AbsenceDetailsTo> toToList(List<AbsenceEntity> absences);

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
