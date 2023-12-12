package pwr.webdatabases.logic.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.util.List;

@Mapper(uses = StudentMapper.class)
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(target = "teacher", source = "lesson.teacher.user.name")
    @Mapping(target = "day", source = "lesson.lessonDay")
    StudentLessonTo toTo(LessonEntity lesson);

    @Mapping(target = "day", source = "lesson.lessonDay")
    TeacherLessonTo toRawTo(LessonEntity lesson);

    @Mapping(target = "day", source = "lesson.lessonDay")
    @Mapping(target = "students", source = "lesson.classEntity.students")
    LessonDetailsTo toStudentsTo(LessonEntity lesson);

    default List<TeacherLessonTo> toRawToList(List<LessonEntity> lessons) {
        return lessons.stream()
            .map(this::toRawTo)
            .toList();
    }

    default List<StudentLessonTo> toDetailsToList(List<LessonEntity> lessons) {
        return lessons.stream()
            .map(this::toTo)
            .toList();
    }
}
