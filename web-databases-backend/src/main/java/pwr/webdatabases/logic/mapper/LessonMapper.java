package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.time.LocalTime;
import java.util.List;

@Mapper(uses = StudentMapper.class)
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(target = "teacher", source = "lesson.teacher.user.name")
    @Mapping(target = "day", source = "lesson.lessonDay")
    StudentLessonTo toStudentTo(LessonEntity lesson);

    @Mapping(target = "day", source = "lesson.lessonDay")
    TeacherLessonTo toTeacherTo(LessonEntity lesson);

    @Mapping(target = "day", source = "lesson.lessonDay")
    @Mapping(target = "students", source = "lesson.classEntity.students")
    LessonDetailsTo toDetailsTo(LessonEntity lesson);

    default String map(LocalTime time) {
        return time.toString();
    }

    default List<TeacherLessonTo> toRawToList(List<LessonEntity> lessons) {
        return lessons.stream()
            .map(this::toTeacherTo)
            .toList();
    }

    default List<StudentLessonTo> toDetailsToList(List<LessonEntity> lessons) {
        return lessons.stream()
            .map(this::toStudentTo)
            .toList();
    }
}
