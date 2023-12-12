package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.logic.model.GradeDetailsTo;
import pwr.webdatabases.logic.model.GradeTo;

import java.util.List;

@Mapper
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    GradeTo toTo(GradeEntity grade);
    GradeEntity toEntity(GradeTo grade);
    List<GradeDetailsTo> toDetailsToList(List<GradeEntity> grades);

    default Long mapTeacher(TeacherEntity teacher) {
        if (null == teacher) {
            return null;
        }
        return teacher.getId();
    }

    default Long mapLesson(LessonEntity lesson) {
        if (null == lesson) {
            return null;
        }
        return lesson.getId();
    }

    default Long mapStudent(StudentEntity student) {
        if (null == student) {
            return null;
        }
        return student.getId();
    }

     default TeacherEntity mapTeacher(Long id) {

        if (null == id) {
            return null;
        }
        TeacherEntity teacher = new TeacherEntity();
        teacher.setId(id);

        return teacher;
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
